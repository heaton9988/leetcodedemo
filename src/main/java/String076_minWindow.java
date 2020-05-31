import java.util.HashSet;

public class String076_minWindow {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        char[] cs = s.toCharArray();
        int n = s.length();
        String res = "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int left = 0;

        HashSet<Character> letter = new HashSet<>();
        for (char c : t.toCharArray()) letter.add(c);
        int len = letter.size();
        for (int right = 0; right < n; right++) {
            if (letter.contains(cs[right])) {
                count[cs[right]] = count[cs[right]] - 1;
                if (count[cs[right]] == 0) {
                    len--;
                }
            }

            while (len == 0) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                if (letter.contains(cs[left])) {
                    if (count[cs[left]] == 0) {
                        len++;
                    }
                    count[cs[left]]++;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : res;
    }

    public static void main(String[] args) {
//        Object o = new String076_minWindow().minWindow("aa", "aa");
        Object o = new String076_minWindow().minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(o);
    }
}