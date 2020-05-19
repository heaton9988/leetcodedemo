import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (j == n - 1 || nums[j] != nums[j + 1] - 1) {
                res.add(nums[i] + (i == j ? "" : "->" + nums[j]));
                i = j + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        输入: [0,1,2,4,5,7]
//        输出: ["0->2","4->5","7"]
        long start = System.currentTimeMillis();
        SummaryRanges228 obj = new SummaryRanges228();
//        System.out.println(obj.maxProduct(new int[]{-2,0,-1}));
        System.out.println(obj.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}