public class String003_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int res = 0;

        char[] cs = s.toCharArray();
        int[] count = new int[128];
        for (int left = 0, right = 0; right < n; right++) {
            count[cs[right]]++;
            if (count[cs[right]] == 1) {
                if (right - left + 1 > res) res = right - left + 1;
            }
            while (count[cs[right]] > 1) {
                count[cs[left]]--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new String003_lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcda");

        System.out.println(o);
    }
}