import java.util.Stack;

public class Stack227_calculate {
    char[] cs;
    int len;

    Stack<Integer> operand = new Stack<>();
    Stack<Character> ops = new Stack<>();

    boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    int calc(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public int calculate(String s) {
        cs = s.trim().toCharArray();
        len = cs.length;

        int sum = -1;
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == ' ') continue;
            if (isDigit(c)) {
                if (sum == -1) {
                    sum = c - '0';
                } else {
                    sum = sum * 10 + c - '0';
                }
                if (i == len - 1 && sum != -1) {
                    if (!ops.isEmpty()) {
                        char lastOp = ops.peek();
                        if (lastOp == '*' || lastOp == '/') {
                            sum = calc(operand.pop(), sum, ops.pop());
                        }
                    }
                    operand.push(sum);
                }
            } else {
                if (sum != -1) {
                    if (!ops.isEmpty()) {
                        char lastOp = ops.peek();
                        if (lastOp == '*' || lastOp == '/') {
                            sum = calc(operand.pop(), sum, ops.pop());
                        }
                    }
                    operand.push(sum);
                    sum = -1;
                }
                if (isOperation(c)) {
                    if (c == '+' || c == '-') {
                        if (!ops.isEmpty()) {
                            char lastOp = ops.peek();
                            if (lastOp == '+' || lastOp == '-') {
                                int a2 = operand.pop();
                                int a1 = operand.pop();
                                operand.push(calc(a1, a2, ops.pop()));
                            }
                        }
                    }
                    ops.push(c);
                }
            }
        }
        int res = 0;
        while (!operand.isEmpty()) {
            if (!ops.isEmpty() && ops.pop() == '-') {
                res -= operand.pop();
            } else {
                res += operand.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Stack227_calculate obj = new Stack227_calculate();
        long start = System.currentTimeMillis();
        String ex = " 3/2 ";
        ex = "14-3/2";
//        ex = "2-1+2";
//        ex = "(1+(4+5+2)-3)+(6+8)";
//        ex = Integer.MAX_VALUE + "";
        Object o = obj.calculate(ex);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}