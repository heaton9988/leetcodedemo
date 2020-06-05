import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class String267_generatePalindromes_3 {
    Set<String> set = new HashSet<>();

    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        if (!canPermutePalindrome(s, map))
            return new ArrayList<>();
        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1)
                ch = (char) i;
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char) i;
            }
        }
        permute(st, 0, ch);
        return new ArrayList<String>(set);
    }

    public boolean canPermutePalindrome(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    void permute(char[] cs, int start, char ch) {
        if (start == cs.length) {
            set.add(new String(cs) + (ch == 0 ? "" : ch) + new StringBuffer(new String(cs)).reverse());
        } else {
            for (int i = start; i < cs.length; i++) {
                if (cs[start] != cs[i] || start == i) {
                    swap(cs, start, i);
                    permute(cs, start + 1, ch);
                    swap(cs, start, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String267_generatePalindromes_3().generatePalindromes("aaaabbc");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}