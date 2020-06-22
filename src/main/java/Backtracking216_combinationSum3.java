import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtracking216_combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    int k, n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        helper(1, new LinkedList<>(), 0);
        return res;
    }

    private void helper(int start, LinkedList<Integer> list, int lastSum) {
        if (list.size() == k) {
            if (lastSum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        } else if (list.size() == k - 1 && lastSum + 9 < n) {
            return;
        }
        for (int i = start; i < 10; i++) {
            int currSum = lastSum + i;
            if (currSum > n) break;
            list.add(i);
            helper(i + 1, list, currSum);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking216_combinationSum3().combinationSum3(3, 15);
        System.out.println(o);
    }
}