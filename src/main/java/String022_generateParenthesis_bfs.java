import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class String022_generateParenthesis_bfs {
    class Node {
        private String res; // 当前得到的字符串
        private int left; // 剩余左括号数量
        private int right; // 剩余右括号数量

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String022_generateParenthesis_bfs().generateParenthesis(3);
        System.out.println(o);
        System.out.println(((List<String>) o).size());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}