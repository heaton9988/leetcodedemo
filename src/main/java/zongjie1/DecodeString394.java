package zongjie1;

import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        if (s == null || s.trim().length() == 0) return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                numStack.push(num);
            } else if (c >= 'a' && c <= 'z') {
                res += c;
                idx++;
            } else if (c == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int num = numStack.pop();
                for (int i = 0; i < num; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String param = "3[a2[c]]4[c2[b]]";
        Object o = new DecodeString394().decodeString(param);
        System.out.println(o);
    }
}