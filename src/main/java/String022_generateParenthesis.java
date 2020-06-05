import java.util.ArrayList;
import java.util.List;

/**
 * 参考了官方的暴力解法, 做了简单的优化, 0ms击败了100%
 */
public class String022_generateParenthesis {

    ArrayList<String> res = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        char[] cs = new char[n * 2];
        helper(cs, 0, 0, 0, 0);
        return res;
    }

    private void helper(char[] cs, int position, int sum, int leftSum, int rightSum) {
        if (position == cs.length) {
            res.add(new String(cs));
        } else {
            if (leftSum < n) {
                cs[position] = '(';
                helper(cs, position + 1, sum + 1, leftSum + 1, rightSum);
            }
            if (sum > 0) {
                cs[position] = ')';
                helper(cs, position + 1, sum - 1, leftSum, rightSum + 1);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String022_generateParenthesis().generateParenthesis(10);
        System.out.println(o);
        System.out.println(((List<String>) o).size());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}