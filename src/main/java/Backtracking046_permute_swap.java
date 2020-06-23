import java.util.ArrayList;
import java.util.List;

public class Backtracking046_permute_swap {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return ans;
    }

    private void helper(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) list.add(x) ;
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            helper(nums, index + 1);
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking046_permute_swap().permute(new int[]{1, 2, 3});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}