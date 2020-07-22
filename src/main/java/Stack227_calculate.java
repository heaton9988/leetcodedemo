public class Stack227_calculate {
    char[] cs;
    int len;

    int[] operand;
    char[] ops;
    int sizeOperand = 0, sizeOps = 0;

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
        operand = new int[len / 2 + 1];
        ops = new char[len / 2 + 1];

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
                    if (sizeOps > 0) {
                        if (ops[sizeOps - 1] == '*' || ops[sizeOps - 1] == '/') {
                            sum = calc(operand[--sizeOperand], sum, ops[--sizeOps]);
                        }
                    }
                    operand[sizeOperand++] = sum;
                }
            } else {
                if (sum != -1) {
                    if (sizeOps > 0) {
                        if (ops[sizeOps - 1] == '*' || ops[sizeOps - 1] == '/') {
                            sum = calc(operand[--sizeOperand], sum, ops[--sizeOps]);
                        }
                    }
                    operand[sizeOperand++] = sum;
                    sum = -1;
                }
                if (isOperation(c)) {
                    if (c == '+' || c == '-') {
                        if (sizeOps > 0) {
                            if (ops[sizeOps - 1] == '+' || ops[sizeOps - 1] == '-') {
                                int a2 = operand[--sizeOperand];
                                int a1 = operand[--sizeOperand];
                                operand[sizeOperand++] = calc(a1, a2, ops[--sizeOps]);
                            }
                        }
                    }
                    ops[sizeOps++] = c;
                }
            }
        }
        int res = 0;
        while (sizeOperand > 0) {
            if (sizeOps > 0 && ops[--sizeOps] == '-') {
                res -= operand[--sizeOperand];
            } else {
                res += operand[--sizeOperand];
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