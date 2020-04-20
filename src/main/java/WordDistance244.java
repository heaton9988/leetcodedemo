import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance244 {
    private HashMap<String, List<Integer>> word2idxs = new HashMap<>();

    public WordDistance244(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = word2idxs.get(words[i]);
            if (list == null) {
                list = new ArrayList<>();
                word2idxs.put(words[i], list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1Indexs = word2idxs.get(word1);
        List<Integer> word2Indexs = word2idxs.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < word1Indexs.size() && j < word2Indexs.size()) {
            int w1Index = word1Indexs.get(i), w2Index = word2Indexs.get(j);
            res = Math.min(res, Math.abs(w1Index - w2Index));
            if (w1Index < w2Index) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordDistance244 obj = new WordDistance244(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        long start = System.currentTimeMillis();

        Object v = obj.shortest("makes", "coding");
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}