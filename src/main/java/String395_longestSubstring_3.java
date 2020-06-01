public class String395_longestSubstring_3 {
    public int longestSubstring(String s, int k) {
        // 处理空串
        if (s == null || s.length() == 0) return 0;
        int[] freq = new int[26];
        boolean flag = true;
        // 统计字母出现频率
        char[] str = s.toCharArray();
        for (char ch : str) {
            freq[ch - 'a']++;
        }
        // 处理全是高频字母的字符串
        for (int f : freq) {
            if (f != 0 && f < k) {
                flag = false;
            }
        }
        if (flag) {
            return s.length();
        }
        // 遍历字符串，用低频字母将字符串切分成若干子串，再递归验证子串是否符合题意
        int start = 0, ans = 0;
        for (int cur = 0; cur < s.length(); cur++) {
            char ch = s.charAt(cur);
            if (freq[ch - 'a'] < k) {
                ans = Math.max(ans, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
        }
        // 处理不以低频子串结束的情况
        return Math.max(ans, longestSubstring(s.substring(start), k));
    }

    public static void main(String[] args) {
        Object o = new String395_longestSubstring_3().longestSubstring("ababbcaab", 2);
        System.out.println(o);
    }
}