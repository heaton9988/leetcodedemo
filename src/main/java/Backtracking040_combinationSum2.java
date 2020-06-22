import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking040_combinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int n, target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;
        helper(0, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int start, List<Integer> list, int sum) {
        if (sum < target) {
            for (int i = start; i < n; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                int currSum = sum + candidates[i];
                if (currSum > target) break;
                list.add(candidates[i]);
                helper(i + 1, list, currSum);
                list.remove(list.size() - 1);
            }
        } else if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking040_combinationSum2().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
        System.out.println(o);
    }
}