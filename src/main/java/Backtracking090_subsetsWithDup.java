import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking090_subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        helper(0, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }

    private void helper(int index, List<Integer> list) {
        if (index >= n) return;
        for (int i = index; i < n; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            helper(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking090_subsetsWithDup().subsetsWithDup(new int[]{1, 1, 2, 2});
        System.out.println(o);
    }
}