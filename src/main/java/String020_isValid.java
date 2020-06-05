import java.util.*;

public class String020_isValid {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for (char c : cs) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String020_isValid().isValid("()[]}");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}