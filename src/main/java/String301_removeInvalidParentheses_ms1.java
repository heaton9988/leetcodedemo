import java.util.ArrayList;
import java.util.List;

public class String301_removeInvalidParentheses_ms1 {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        List<String> res = new ArrayList<>();
        backtrace(cs, 0, new StringBuilder(s.length() - left - right), res, 0, 0, left, right);
        return res;
    }

    private void backtrace(char[] cs, int cur, StringBuilder sb, List<String> res,
                           int left, int right, int remL, int remR) {
        if (cur == cs.length) {
            if (remL == 0 && remR == 0) res.add(sb.toString());
            return;
        }
        if (right > left) return;
        final int len = sb.length();
        if (cs[cur] == '(') {
            // use
            sb.append('(');
            backtrace(cs, cur + 1, sb, res, left + 1, right, remL, remR);
            sb.setLength(len);
            if (remL > 0) { // not use
                while (cur < cs.length && cs[cur] == '(') { // find next
                    cur++;
                    remL--;
                }
                if (remL >= 0) backtrace(cs, cur, sb, res, left, right, remL, remR);
            }
        } else if (cs[cur] == ')') {
            // use
            sb.append(')');
            backtrace(cs, cur + 1, sb, res, left, right + 1, remL, remR);
            sb.setLength(len);
            if (remR > 0) { // not use
                while (cur < cs.length && cs[cur] == ')') { // find next
                    cur++;
                    remR--;
                }
                if (remR >= 0) backtrace(cs, cur, sb, res, left, right, remL, remR);
            }
        } else {
            sb.append(cs[cur]);
            backtrace(cs, cur + 1, sb, res, left, right, remL, remR);
            sb.setLength(len);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("()())()");
//        Object o = new String301_removeInvalidParentheses().removeInvalidParentheses("(a)())()");
        Object o = new String301_removeInvalidParentheses_ms1().removeInvalidParentheses(")(");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}