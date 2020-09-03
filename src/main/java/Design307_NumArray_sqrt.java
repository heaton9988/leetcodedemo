public class Design307_NumArray_sqrt {
    private int[] dp;
    private int len;
    private int[] nums;

    public Design307_NumArray_sqrt(int[] nums) {
        this.nums = nums;
        len = (int) Math.ceil(nums.length / Math.sqrt(nums.length));
        dp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            dp[i / len] += nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k < (startBlock + 1) * len; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k < endBlock; k++)
                sum += dp[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void update(int i, int val) {
        int block = i / len;
        dp[block] = dp[block] - nums[i] + val;
        nums[i] = val;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design307_NumArray_sqrt obj = new Design307_NumArray_sqrt(new int[]{1, 3, 5});
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}