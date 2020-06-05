import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class String022_generateParenthesis_timeout {
    HashSet<String> res = new HashSet<>(10000);

    public List<String> generateParenthesis(int n) {
        char[] cs = new char[n * 2];
        for (int i = 0; i < n; i++) {
            cs[i] = '(';
            cs[2 * n - 1 - i] = ')';
        }
        helper(cs, 0, 0);
        return new ArrayList<>(res);
    }

    private void helper(char[] cs, int start, int count) {
        if (start == cs.length) {
            res.add(new String(cs));
        }
        for (int i = start; i < cs.length; i++) {
            int sum = count + (cs[i] == ')' ? -1 : 1);
            if (sum < 0) continue;
            if (cs[i] != cs[start] || i == start) {
                swap(cs, i, start);
                helper(cs, start + 1, sum);
                swap(cs, i, start);
            }
        }
    }

    private void swap(char[] c, int i, int j) {
        if (i != j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String022_generateParenthesis_timeout().generateParenthesis(8);
        System.out.println(o);
        System.out.println(((List<String>) o).size());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}