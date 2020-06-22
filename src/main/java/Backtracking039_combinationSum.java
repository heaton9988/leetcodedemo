import java.util.ArrayList;
import java.util.List;

public class Backtracking039_combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int n, target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;

        helper(0, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int start, List<Integer> list, int sum) {
        if (sum < target) {
            for (int i = start; i < n; i++) {
                list.add(candidates[i]);
                int currSum = sum + candidates[i];
                helper(i, list, currSum);
                list.remove(list.size() - 1);
                if (currSum > target) break;
            }
        } else if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking039_combinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(o);
    }
}