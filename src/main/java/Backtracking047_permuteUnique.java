import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking047_permuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        helper(0, new boolean[n], new ArrayList<>());
        return res;
    }

    private void helper(int start, boolean[] used, List<Integer> list) {
        if (start == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(start + 1, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking047_permuteUnique().permuteUnique(new int[]{1, 2, 2});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}