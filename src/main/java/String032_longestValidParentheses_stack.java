import java.util.Stack;

public class String032_longestValidParentheses_stack {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String032_longestValidParentheses_stack().longestValidParentheses("()()");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}