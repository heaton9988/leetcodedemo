import java.util.Stack;

public class String032_longestValidParentheses_timeout {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                System.out.println(i + "," + j + "\t" + isValid(s.substring(i, j)));
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String032_longestValidParentheses_timeout().longestValidParentheses("(()()");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}