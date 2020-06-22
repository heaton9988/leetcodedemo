import java.util.ArrayList;
import java.util.List;

public class Backtracking077_combine {
    int n, k;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }
        this.n = n;
        this.k = k;
        backtrack(n, 1, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int start, int left, List<Integer> list) {
        if (left == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n, i + 1, left - 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Object o = new Backtracking077_combine().combine(4, 2);
        System.out.println(o);
    }
}