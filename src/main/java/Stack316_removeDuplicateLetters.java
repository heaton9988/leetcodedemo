import java.util.*;

public class Stack316_removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;

        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[cs[i] - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        char[] stack = new char[len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (seen[c - 'a']) continue;
            while (size > 0 && c < stack[size - 1] && lastIndex[stack[size - 1] - 'a'] > i - 1) {
                seen[stack[--size] - 'a'] = false;
            }
            stack[size++] = c;
            seen[c - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append(stack[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        Stack316_removeDuplicateLetters obj = new Stack316_removeDuplicateLetters();
        long start = System.currentTimeMillis();
        Object o = obj.removeDuplicateLetters("cbacdcbc");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}