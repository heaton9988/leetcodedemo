import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String030_findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> baseMap = new HashMap<>();
        int wordLen = words[0].length();
        int wordCount = words.length;
        for (String word : words) {
            baseMap.put(word, baseMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String subRight = s.substring(right, right + wordLen);
                tempMap.put(subRight, tempMap.getOrDefault(subRight, 0) + 1);
                right += wordLen;
                count++;

                while (true) {
                    int tempCount = tempMap.getOrDefault(subRight, 0);
                    int baseCount = baseMap.getOrDefault(subRight, 0);
                    if (tempCount <= baseCount) {
                        break;
                    }
                    String subLeft = s.substring(left, left + wordLen);
                    count--;
                    tempMap.put(subLeft, tempMap.getOrDefault(subLeft, 0) - 1);
                    left += wordLen;
                }
                if (count == wordCount) {
                    res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Object o = new String030_findSubstring().findSubstring("abarfoothefoobarman", new String[]{"foo", "bar"});
//        Object o = new String030_findSubstring().findSubstring("abarfoothefoobarman", new String[]{"foo", "bar"});
        Object o = new String030_findSubstring().findSubstring("aaaaaabbcc", new String[]{"aa", "aa", "bb"});

        System.out.println(o);
    }
}