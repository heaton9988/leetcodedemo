public class BinarySearch300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int res = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int dpValue = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpValue = Math.max(dpValue, dp[j] + 1);
                }
            }
            dp[i] = dpValue;
            if (dpValue > res) res = dpValue;
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BinarySearch300_lengthOfLIS obj = new BinarySearch300_lengthOfLIS();
//        System.out.println(obj.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(obj.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}