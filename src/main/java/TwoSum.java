import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer diffValue = map.get(target - num);
            if (diffValue != null) {
                return new int[]{i, diffValue};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 26;

        int[] ints = twoSum(arr, target);
        System.out.println();
    }
}