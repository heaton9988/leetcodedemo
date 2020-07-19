import java.util.Stack;

public class Stack150_evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(calc(token.charAt(0), op1, op2));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calc(char op, int op1, int op2) {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Stack150_evalRPN obj = new Stack150_evalRPN();
        long start = System.currentTimeMillis();

        int i = obj.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
//        int i = obj.evalRPN(new String[]{"4", "13", "5", "/", "+"});
//        int i = obj.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}