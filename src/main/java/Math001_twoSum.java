import java.util.Arrays;
import java.util.HashMap;

public class Math001_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 26;

        int[] ints = twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}