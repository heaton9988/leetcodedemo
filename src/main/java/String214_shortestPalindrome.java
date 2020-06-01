import java.util.Stack;

public class String214_shortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) return "";
        int start = n / 2;
        Stack<Character> stack = new Stack<>();
        for (int i = start; i >= 0; i--) {
            int l = i, r = i;
            while (l > 0 && cs[l - 1] == cs[l]) {
                l--;
            }
            while (r < n - 1 && cs[r + 1] == cs[r]) {
                r++;
            }
            while (l >= 0 && r < n && cs[l] == cs[r]) {
                l--;
                r++;
            }
            if (l < 0) {
                while (r < n) {
                    stack.push(cs[r++]);
                }
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
//        Object o = new String214_shortestPalindrome().shortestPalindrome("ba");
//        Object o = new String214_shortestPalindrome().shortestPalindrome("abcd");
//        Object o = new String214_shortestPalindrome().shortestPalindrome("aacecaaa");
        Object o = new String214_shortestPalindrome().shortestPalindrome("aaaa");
//        Object o = new String214_shortestPalindrome().shortestPalindrome("abbacd");
        System.out.println(o);
    }
}