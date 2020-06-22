import java.util.Arrays;

public class Backtracking377_combinationSum4_timeout {
    int res = 0;
    int[] nums;
    int n;
    int target;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        this.target = target;
        helper(0, 0);
        return res;
    }

    private void helper(int start, int preSum) {
        if (preSum == target) {
            res++;
            return;
        } else if (preSum > target) {
            return;
        }
        for (int i = start; i < n; i++) {
            int currSum = preSum + nums[i];
            if (currSum > target) break;
            helper(0, currSum);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking377_combinationSum4_timeout().combinationSum4(new int[]{1, 2, 3}, 35);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}