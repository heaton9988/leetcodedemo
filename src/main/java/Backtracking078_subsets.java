import java.util.ArrayList;
import java.util.List;

public class Backtracking078_subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if (list.size() == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking078_subsets().subsets(new int[]{1, 2, 3});
        System.out.println(o);
    }
}