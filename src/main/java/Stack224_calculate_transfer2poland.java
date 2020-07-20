import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack224_calculate_transfer2poland {
    public int calculate(String s) {
        String[] polish = getPolish(s); //转后缀表达式
        return evalRPN(polish);
    }

    //中缀表达式转后缀表达式
    private String[] getPolish(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        int n = array.length;
        int temp = -1; //累加数字，-1 表示当前没有数字
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') continue;

            if (isNumber(array[i])) { // 遇到数字
                //进行数字的累加
                if (temp == -1) {
                    temp = array[i] - '0';
                } else {
                    temp = temp * 10 + array[i] - '0';
                }
            } else { // 遇到其它操作符，将数字加入到结果中
                if (temp != -1) {
                    res.add(temp + "");
                    temp = -1;
                }
                if (isOperation(array[i] + "")) {
                    //遇到操作符将栈中的操作符加入到结果中
                    while (!stack.isEmpty()) {
                        //遇到左括号结束
                        if (stack.peek().equals("(")) {
                            break;
                        }
                        res.add(stack.pop());
                    }
                    //当前操作符入栈
                    stack.push(array[i] + "");
                } else {
                    //遇到左括号，直接入栈
                    if (array[i] == '(') {
                        stack.push(array[i] + "");
                    }
                    //遇到右括号，将出栈元素加入到结果中，直到遇到左括号
                    if (array[i] == ')') {
                        while (!stack.peek().equals("(")) {
                            res.add(stack.pop());
                        }
                        //左括号出栈
                        stack.pop();
                    }

                }
            }
        }
        //如果有数字，将数字加入到结果
        if (temp != -1) {
            res.add(temp + "");
        }
        //栈中的其他元素加入到结果
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        String[] sArray = new String[res.size()];
        //List 转为 数组
        for (int i = 0; i < res.size(); i++) {
            sArray[i] = res.get(i);
        }
        return sArray;
    }

    // 下边是 150 题的代码，求后缀表达式的值
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (isOperation(t)) {
                int a = stringToNumber(stack.pop());
                int b = stringToNumber(stack.pop());
                int ans = eval(b, a, t.charAt(0));
                stack.push(ans + "");
            } else {
                stack.push(t);
            }
        }
        return stringToNumber(stack.pop());
    }

    private int eval(int a, int b, char op) {
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

    private int stringToNumber(String s) {
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * sign;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }

    public static void main(String[] args) {
        Stack224_calculate_transfer2poland obj = new Stack224_calculate_transfer2poland();
        long start = System.currentTimeMillis();
        String ex = "19-(4-2+1)";
//        ex = "1+1";
//        ex = "2-1+2";
//        ex = "(1+(4+5+2)-3)+(6+8)";
//        ex = Integer.MAX_VALUE + "";
        Object o = obj.calculate(ex);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}