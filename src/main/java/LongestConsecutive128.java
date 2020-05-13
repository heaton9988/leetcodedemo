import java.util.Arrays;

public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int res = 1;
        int currSum = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[i - 1]) continue;
            if (num - 1 == lastNum) {
                currSum++;
                if (currSum > res) res = currSum;
            } else {
                currSum = 1;
            }
            lastNum = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2};
        LongestConsecutive128 obj = new LongestConsecutive128();
        long start = System.currentTimeMillis();
        System.out.println(obj.longestConsecutive(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}