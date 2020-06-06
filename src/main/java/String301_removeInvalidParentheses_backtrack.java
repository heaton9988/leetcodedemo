import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String301_removeInvalidParentheses_backtrack {
    private Set<String> validExpressions = new HashSet<>();
    private int minimumRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }

    private void recurse(String s, int index, int leftCount, int rightCount,
                         StringBuilder expression, int removedCount) {
        if (index != s.length()) {
            char c = s.charAt(index);
            int exLen = expression.length();
            if (c == '(' || c == ')') {
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);

                expression.append(c); // 不往expression里加东西, 就代表删, 加东西, 代表保留字符
                if (c == '(') {
                    this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // For a closing parenthesis, only recurse if right < left
                    this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                // Undoing the append operation for other recursions.
                expression.deleteCharAt(exLen);
                // 恢复
            } else { // 如果不是括号, simply recurse further by adding it to the expression StringBuilder
                expression.append(c);
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(exLen);
            }
        } else { // If we have reached the end of string.
            // If the current expression is valid.
            if (leftCount == rightCount) {
                // If the current count of removed parentheses is <= the current minimum count
                if (removedCount <= this.minimumRemoved) {
                    // Convert StringBuilder to a String. This is an expensive operation.
                    // So we only perform this when needed.
                    String possibleAnswer = expression.toString();
                    // If the current count beats the overall minimum we have till now
                    if (removedCount < this.minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        }
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("()())()");
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("(a)())()");
        Object o = new String301_removeInvalidParentheses_backtrack().removeInvalidParentheses(")(");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}