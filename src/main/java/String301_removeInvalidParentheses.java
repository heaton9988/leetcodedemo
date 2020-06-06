import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class String301_removeInvalidParentheses {
    HashSet<String> set = new HashSet<>();
    int n;

    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        n = cs.length;

        int lDel = 0;
        int rDel = 0;
        for (char c : cs) {
            if (c == '(') {
                lDel++;
            } else if (c == ')') {
                if (lDel > 0) {
                    lDel--;
                } else {
                    rDel++;
                }
            }
        }
        help(s, 0, 0, 0, lDel, rDel, new StringBuilder());
        return new ArrayList<>(set);
    }

    private void help(String s, int index, int left, int right, int lDel, int rDel, StringBuilder temp) {
        if (index == n) {
            if (left == right && lDel == 0 && rDel == 0) {
                set.add(temp.toString());
            }
        } else {
            char c = s.charAt(index);
            int tempLen = temp.length();
            if (c != '(' && c != ')') {
                temp.append(c);
                help(s, index + 1, left, right, lDel, rDel, temp);
                temp.setLength(tempLen);
            } else {
                if (c == '(' && lDel > 0) { // 丢弃
                    int i = index+1;
                    while (s.charAt(i)=='('){

                    }
                    help(s, index + 1, left, right, lDel - 1, rDel, temp);
                } else if (rDel > 0) {
                    help(s, index + 1, left, right, lDel, rDel - 1, temp);
                }

                temp.append(c);
                if (c == '(') {
                    help(s, index + 1, left + 1, right, lDel, rDel, temp);
                } else if (right < left) {
                    help(s, index + 1, left, right + 1, lDel, rDel, temp);
                }
                temp.setLength(tempLen);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("()())()");
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("(a)())()");
        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses(")(");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}