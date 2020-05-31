import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String030_findSubstring_3 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        Map<String, Integer> baseMap = new HashMap<>();
        for (String w : words) baseMap.put(w, baseMap.getOrDefault(w, 0) + 1);

        int wordLen = words[0].length();
        int n = words.length;
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> tempMap = new HashMap<>();

            int count = 0;
            while (right + wordLen <= s.length()) {
                String subRight = s.substring(right, right + wordLen);
                tempMap.put(subRight, tempMap.getOrDefault(subRight, 0) + 1);
                right += wordLen;
                count++;

                while (tempMap.getOrDefault(subRight,0) > baseMap.getOrDefault(subRight,0)) {
                    String subLeft = s.substring(left, left + wordLen);
                    tempMap.put(subLeft, tempMap.get(subLeft) - 1);
                    count--;
                    left += wordLen;
                }
                if (count == n) {
                    res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Object o = new String030_findSubstring().findSubstring("abarfoothefoobarman", new String[]{"foo", "bar"});
        Object o = new String030_findSubstring_3().findSubstring("aaaaaabbcc", new String[]{"aa", "aa", "bb"});

        System.out.println(o);
    }
}