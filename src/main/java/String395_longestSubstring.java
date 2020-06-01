public class String395_longestSubstring {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        int count[] = new int[128];
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (char c : cs) {
            count[c]++;
        }
        boolean f = true;
        for (int c : count) {
            if (c != 0 && c < k) {
                f = false;
                break;
            }
        }
        if (f) return s.length();
        int res = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (count[cs[right]] < k) {
                res = Math.max(res, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
        }
        return Math.max(res, longestSubstring(s.substring(left), k));
    }

    public static void main(String[] args) {
        Object o = new String395_longestSubstring().longestSubstring("a", 2);
        System.out.println(o);
    }
}