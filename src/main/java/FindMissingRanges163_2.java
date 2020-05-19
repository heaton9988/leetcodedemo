import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges163_2 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add(lower + (lower == upper ? "" : "->" + upper));
            return res;
        }
        long left = lower;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > left) {
                res.add(left + (left == num - 1 ? "" : "->" + (num - 1)));
            }
            left = num + 1L;
        }
        if (upper > nums[n - 1]) {
            res.add(nums[n - 1] + 1 + (upper == nums[n - 1] + 1 ? "" : "->" + upper));
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FindMissingRanges163_2 obj = new FindMissingRanges163_2();
        System.out.println(obj.findMissingRanges(new int[]{-2147483648,-2147483648,0,2147483647,2147483647}, -2147483648, 2147483647));
//        System.out.println(obj.findMissingRanges(new int[]{1, 1, 1}, 1, 2));
//        System.out.println(obj.findMissingRanges(new int[]{}, 1, 1));
//        System.out.println(obj.findMissingRanges(new int[]{0, 0, 1, 1, 3, 3, 20, 20}, 0, 22));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}