import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Backtracking254_getFactors_stack {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        lists.clear();
        helper(new Stack<>(), n);
        return lists;
    }

    public void helper(Stack<Integer> stack, int val) {
        if (val == 1)
            return;
        if (stack.size() != 0) {
            List<Integer> list = new ArrayList<>(stack);
            list.add(val);
            lists.add(list);
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0 && (stack.isEmpty() || i >= stack.peek())) {
                stack.add(i);
                helper(stack, val / i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking254_getFactors_stack().getFactors(16);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}