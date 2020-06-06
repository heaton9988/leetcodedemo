import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String301_removeInvalidParentheses_backtrack_limited {
    private Set<String> validExpressions = new HashSet<>();

    private void recurse(String s, int index,
                         int leftCount, int rightCount,
                         int leftRem, int rightRem,
                         StringBuilder expression) {
        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions.add(expression.toString());
            }
        } else {
            char c = s.charAt(index);
            int length = expression.length();

            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if (c == '(' && leftRem > 0) {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, expression);
            }
            if (c == ')' && rightRem > 0) {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, expression);
            }
            expression.append(c);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (c != '(' && c != ')') {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (c == '(') {
                // Consider an opening bracket.
                this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                // Consider a closing bracket.
                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }

            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0; // 分别计算左右括号多了多少
        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {
            // Simply record the left one.
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
                // If we don't have a matching left, then this is a misplaced right, record it.
//                right = left == 0 ? right + 1 : right;

                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
//                left = left > 0 ? left - 1 : left;
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<>(this.validExpressions);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("()())()");
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("(a)())()");
        Object o = new String301_removeInvalidParentheses_backtrack_limited().removeInvalidParentheses(")(");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}