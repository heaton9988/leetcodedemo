public class Stack224_calculate {
    char[] cs;
    int len;
    int index = 0;

    String[] stack;
    char[] ops;
    int sizeStack = 0, sizeOps = 0;

    public int calculate(String s) {
        cs = s.toCharArray();
        len = cs.length;
        stack = new String[len / 2 + 1];
        ops = new char[len / 2 + 1];
        while (index < len) {
            char c = cs[index++];
            if (c == '-' || c == '+') {
                ops[sizeOps++] = c;
            } else if (Character.isDigit(c)) {
                stack[sizeStack++] = c + "";
            } else if (c == '(') {
                stack[sizeStack++] = c + "";
            } else if (c == ')') {
                Integer res = 0;
                while (!stack[sizeStack - 2].equals("(")) {
                    res += calc(0, Integer.parseInt(stack[--sizeStack]), ops[--sizeOps]);
                }
                res += Integer.parseInt(stack[--sizeStack]);
                --sizeStack;
                stack[sizeStack++] = res + "";
            }
        }

        int res = Integer.parseInt(stack[0]);
        for (int i = 1; i < sizeStack; i++) {
            res += calc(0, Integer.parseInt(stack[i]), ops[i - 1]);
        }
        return res;
    }

    private int calc(int a1, int a2, char op) {
        switch (op) {
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Stack224_calculate obj = new Stack224_calculate();
        long start = System.currentTimeMillis();
        String ex = "9-(4-2+1)";
        ex = "1+1";
        ex = "2-1+2";
        ex = "(1+(4+5+2)-3)+(6+8)";
        Object o = obj.calculate(ex);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}