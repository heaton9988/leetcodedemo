public class MinimumWindowSubstring076_answer1 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s == null || t == null) return "";
        int count = t.length();
        int[] dict = new int[128];

        for (char c : t.toCharArray()) {
            dict[c]++;
        }
        int left = 0, right = 0;
        int answer = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        while (right < s.length()) {
            if (dict[s.charAt(right++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (answer > right - left) {
                    answer = right - left;
                    l = left;
                    r = right;
                }
                if (++dict[s.charAt(left++)] > 0) {
                    count++;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? "" : s.substring(l, r);
    }


    public static void main(String[] args) throws Exception {
        MinimumWindowSubstring076_answer1 obj = new MinimumWindowSubstring076_answer1();
        long start = System.currentTimeMillis();
        String result = obj.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}