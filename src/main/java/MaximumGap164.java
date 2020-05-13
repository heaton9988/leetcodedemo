import java.util.Arrays;

public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 1};
        MaximumGap164 obj = new MaximumGap164();
        long start = System.currentTimeMillis();
        System.out.println(obj.maximumGap(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}