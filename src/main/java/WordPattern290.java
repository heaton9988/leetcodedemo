import java.util.HashMap;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        char[] cs = pattern.toCharArray();
        String[] ss = str.split(" ");
        int n = pattern.length();
        if (n != ss.length) return false;

        HashMap<String, Character> s2c = new HashMap<>();
        String store[] = new String[128];
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            String s = ss[i];
            if (s2c.containsKey(s) && s2c.get(s) != c) {
                return false;
            } else if (store[c] == null) {
                store[c] = s;
                s2c.put(s, c);
            } else if (!store[c].equals(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new WordPattern290().wordPattern("abba", "dog dog dog dog");
        System.out.println(o);
    }
}