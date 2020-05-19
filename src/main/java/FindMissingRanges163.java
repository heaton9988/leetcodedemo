import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        int indexNums = 0;
        long left = lower;

        if (n == 0) {
            res.add(lower + (lower == upper ? "" : "->" + upper));
            return res;
        }

        while (true) {
            while (indexNums < n - 1 && nums[indexNums] == nums[indexNums + 1]) {
                indexNums++;
            }
            if (indexNums < n) {
                if (left == nums[indexNums]) {
                    left = nums[indexNums] + 1L;
                    indexNums++;
                    continue;
                }
                int right = nums[indexNums++] - 1;
                if (left == right) {
                    res.add(left + "");
                    left = right + 2L;
                } else if (left < right) {
                    res.add(left + "->" + right);
                    left = right + 2L;
                }
            } else if (left >= nums[n - 1]) {
                if (nums[n - 1] < upper) {
                    res.add(left + (upper == nums[n - 1] + 1 ? "" : "->" + upper));
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FindMissingRanges163 obj = new FindMissingRanges163();
//        System.out.println(obj.findMissingRanges(new int[]{2147483647}, 2147483647, 2147483647));
        System.out.println(obj.findMissingRanges(new int[]{1, 1, 1}, 1, 2));
//        System.out.println(obj.findMissingRanges(new int[]{}, 1, 1));
//        System.out.println(obj.findMissingRanges(new int[]{0, 0, 1, 1, 3, 3, 20, 20}, 0, 21));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}