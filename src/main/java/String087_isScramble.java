import java.util.HashMap;

public class String087_isScramble {
    HashMap<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        String key = s1 + "," + s2;
        if (map.containsKey(key)) return map.get(key);

        if (s1.equals(s2)) return true;
        int L = s1.length();
        if (L != s2.length()) return false;

        for (int k = 1; k < L; k++) {
            String s10k = s1.substring(0, k);
            String s20k = s2.substring(0, k);
            String s1kL = s1.substring(k, L);
            String s2kL = s2.substring(k, L);

            String s20Lk = s2.substring(0, L - k);
            String s2LkL = s2.substring(L - k, L);

            boolean a = isScramble(s10k, s20k);
            boolean b = isScramble(s1kL, s2kL);
            if (a && b) {
                map.put(key, true);
                return true;
            }
            boolean c = isScramble(s10k, s2LkL);
            boolean d = isScramble(s1kL, s20Lk);
            if (c && d) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    public static void main(String[] args) throws Exception {
        String087_isScramble obj = new String087_isScramble();
        long start = System.currentTimeMillis();
        Object o = obj.isScramble("great", "rgeat");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}