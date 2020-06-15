import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Math259_threeSumSmaller_2 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        for (int i = startIndex; i < nums.length - 1; i++) {
            int j = binarySearch(nums, i, target - nums[i]);
            if (j - i > 0) {
                sum += j - i;
            }
        }
        return sum;
    }

    private int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Object o = new Math259_threeSumSmaller_2().threeSumSmaller(new int[]{-2, 0, 1, 1, 2}, 1);
        System.out.println(o);
    }
}