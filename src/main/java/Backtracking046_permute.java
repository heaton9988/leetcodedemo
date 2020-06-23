import java.util.ArrayList;
import java.util.List;

public class Backtracking046_permute {
    int[] nums;
    int n;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        helper(new ArrayList<>(), new boolean[n]);
        return res;
    }

    private void helper(List<Integer> list, boolean[] used) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                helper(list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking046_permute().permute(new int[]{1, 2, 3});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}