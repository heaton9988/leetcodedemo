public class String340_lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count[] = new int[128];
        char[] cs = s.toCharArray();
        int n = cs.length;
        int sum = 0;
        int res = 0;
        for (int left = 0, right = 0; right < n; right++) {
            count[cs[right]]++;
            if (count[cs[right]] == 1) {
                sum++;
            }
            if (sum <= k) {
                res = Math.max(res, right - left + 1);
            } else if (sum == k + 1) {
                while (sum == k + 1) {
                    count[cs[left]]--;
                    if (count[cs[left]] == 0) {
                        sum--;
                    }
                    left++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new String340_lengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct("a", 2);
        System.out.println(o);
    }
}