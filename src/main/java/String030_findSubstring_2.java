import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String030_findSubstring_2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> baseMap = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        for (String word : words) {
            baseMap.put(word, baseMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!baseMap.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > baseMap.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Object o = new String030_findSubstring().findSubstring("abarfoothefoobarman", new String[]{"foo", "bar"});
//        Object o = new String030_findSubstring().findSubstring("abarfoothefoobarman", new String[]{"foo", "bar"});
        Object o = new String030_findSubstring_2().findSubstring("aaaaaabbcc", new String[]{"aa", "aa", "bb"});

        System.out.println(o);
    }
}