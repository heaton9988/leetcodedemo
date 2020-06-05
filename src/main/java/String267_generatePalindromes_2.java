import java.util.*;

public class String267_generatePalindromes_2 {
    Set<String> set = new HashSet<>();

    public List<String> generatePalindromes(String s) {
        permute(s.toCharArray(), 0);
        return new ArrayList<String>(set);
    }

    public boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[s.length - 1 - i])
                return false;
        }
        return true;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    void permute(char[] cs, int start) {
        if (start == cs.length) {
            if (isPalindrome(cs))
                set.add(new String(cs));
        } else {
            for (int i = start; i < cs.length; i++) {
                swap(cs, start, i);
                permute(cs, start + 1);
                swap(cs, start, i);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String267_generatePalindromes_2().generatePalindromes("aabbhijkkjih");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}