package zongjie1;

public class MinWindow76 {
    public String minWindow(String s, String t) {
        char[] count = new char[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int from = 0;
        int min = Integer.MAX_VALUE;
        int len = t.length();
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]-- > 0) {
                len--;
            }
            while (len == 0) {
                if (right - left + 1 < min) {
                    from = left;
                    min = right - left + 1;
                }
                if (++count[s.charAt(left++)] > 0) {
                    len++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    public static void main(String[] args) {
        Object o = new MinWindow76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(o);
    }
}