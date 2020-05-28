public class IsIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;
        char[] c1c2 = new char[128];
        char[] c2c1 = new char[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            int oldC2 = c1c2[c1];
            int oldC1 = c2c1[c2];
            if (oldC1 == 0 && oldC2 == 0) {
                c1c2[c1] = c2;
                c2c1[c2] = c1;
            } else if (oldC2 != 0) {
                if (oldC2 != c2) return false;
            } else if (oldC1 != 0) {
                if (oldC1 != c1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = new IsIsomorphic205().isIsomorphic("ab", "aa");
        System.out.println(isomorphic);
    }
}