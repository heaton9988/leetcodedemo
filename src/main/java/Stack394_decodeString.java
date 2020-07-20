import java.util.Stack;

public class Stack394_decodeString {
    Stack<String> stack = new Stack<>();
    char[] cs;

    public String decodeString(String s) {
        cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '[') {
            } else if (cs[i] == ']') {
                String temp = "";
                boolean hasDigit = false;
                while (true) {
                    String top = stack.pop();
                    if (Character.isDigit(top.charAt(0))) {
                        temp = fillStr(temp, Integer.parseInt(top));
                        hasDigit = true;
                    } else {
                        temp = top + temp;
                    }
                    if (hasDigit) break;
                }
                stack.push(temp);
            } else {
                sb.append(cs[i]);
                boolean b = (i == cs.length - 1 || cs[i + 1] == ']') || (Character.isDigit(cs[i]) && !Character.isDigit(cs[i + 1])) || (!Character.isDigit(cs[i]) && Character.isDigit(cs[i + 1]));
                if (b) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    private String fillStr(String curr, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) sb.append(curr);
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack394_decodeString obj = new Stack394_decodeString();
        long start = System.currentTimeMillis();
//        Object o = obj.decodeString("3[a2[c]]");
//        Object o = obj.decodeString("3[a]2[bc]");
//        Object o = obj.decodeString("2[abc]3[cd]ef");
//        Object o = obj.decodeString("abc3[cd]xyz");
        Object o = obj.decodeString("100[a]");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}