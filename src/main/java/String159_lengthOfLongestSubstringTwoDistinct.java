public class String159_lengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int res = 0;
        int len = 0;
        int[] count = new int[128];
        for (int left = 0, right = 0; right < n; right++) {
            count[cs[right]]++;
            if (count[cs[right]] == 1) {
                len++;
            }
            if (len <= 2) {
                res = Math.max(res, right - left + 1);
            }
            while (len > 2) {
                count[cs[left]]--;
                if (count[cs[left]] == 0) {
                    len--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new String159_lengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("ccaabbb");
        System.out.println(o);
    }
}