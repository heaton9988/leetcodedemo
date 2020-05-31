public class String076_minWindow {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int n = s.length();
        String res = "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int len = 0;
        char[] cs = s.toCharArray();
        for (int right = 0; right < n && left < n; right++) {
            if (count[cs[right]] > 0) {
                count[cs[right]]--;
                len++;
                if (len == t.length()) {
                    if (right - left + 1 < min) {
                        min = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : res;
    }

    public static void main(String[] args) {
        Object o = new String076_minWindow().minWindow("OADOBECODEBANC", "ABC");
        System.out.println(o);
    }
}