import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    public static void main(String[] args) {
        AutocompleteSystem as = new AutocompleteSystem(new String[]{"i love you", "island", "i love leetcode"}, new int[]{5, 3, 2, 2});
        List<String> result = as.input('i');
        result = as.input(' ');
        result = as.input('a');
        result = as.input('#');
        System.out.println();
    }

    private Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        int n = sentences.length;
        for (int i = 0; i < n; ++i)
            trie.insert(sentences[i], times[i]);
    }

    public List<String> input(char c) {
        return trie.searchChar(c);
    }


    static class Trie {
        private TrieNode root;
        private TrieNode current;           // 在插入过程中的当前节点，一句话插完后重置为root
        private PriorityQueue<TrieNode> pq; // 小顶堆，自定义比较函数，用来保存排在前3的句子
        private StringBuilder sb;           // 单个字符输入时，保存已输入字符

        public Trie() {
            root = new TrieNode();
            current = root;
            Comparator<TrieNode> comparator = new Comparator<TrieNode>() {
                public int compare(TrieNode node1, TrieNode node2) {
                    if (node1.times != node2.times)
                        return node1.times - node2.times;
                    return node2.sentence.compareTo(node1.sentence);
                }
            };
            pq = new PriorityQueue(4, comparator);
            sb = new StringBuilder();
        }

        public void insert(String sentence, int times) {
            int n = sentence.length();
            for (int i = 0; i < n; ++i)
                insertNewChar(sentence.charAt(i));
            current.sentence = sentence;
            current.times += times;
            current = root;
        }

        // 插入新字符，并更新current
        // 之前前缀没有该字符，返回true
        private boolean insertNewChar(char c) {
            int charNo = c == ' ' ? 26 : c - 'a';
            if (current.children[charNo] != null) {
                current = current.children[charNo];
                return false;
            }
            current.children[charNo] = new TrieNode();
            current = current.children[charNo];
            return true;
        }

        // 在当前节点中搜索字符，如果为终止符，则结束该句搜索过程
        // 否则，如果插入字符之前没有该前缀，则返回空列表
        // 否则，从该字符所在的点开始，搜索所有句子，并找出其中3个最大的
        public List<String> searchChar(char c) {
            List<String> result = new LinkedList();
            if (c == '#') {
                current.sentence = sb.toString();
                ++current.times;
                current = root;
                sb.delete(0, sb.length());
                return result;
            }

            sb.append(c);

            if (insertNewChar(c))
                return result;

            searchSentence(current);
            while (pq.peek() != null)
                result.add(0, pq.poll().sentence);

            return result;
        }

        // 从node点开始向下寻找句子，保存在优先队列里，超过3个弹出
        private void searchSentence(TrieNode node) {
            if (node.sentence != null) {
                pq.offer(node);
                if (pq.size() > 3)
                    pq.poll();
            }
            for (TrieNode child : node.children) {
                if (child != null)
                    searchSentence(child);
            }
        }
    }

    static class TrieNode {
        public TrieNode[] children;
        public String sentence;     // 如果该点为句子终点，保存整个句子
        public int times;           // 如果该点为句子终点，记录句子热度

        public TrieNode() {
            times = 0;
            children = new TrieNode[27];
            sentence = null;
        }
    }
}
