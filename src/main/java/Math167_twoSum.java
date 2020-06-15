import java.util.Arrays;
import java.util.HashMap;

public class Math167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ints = new Math167_twoSum().twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}