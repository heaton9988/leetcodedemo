public class String161_isOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if (Math.abs(ls - lt) > 1) return false;
        if (ls == 0 || lt == 0) return false;
        if (s.equals(t)) return true;
        if (ls == lt) {
            int l = 0, r = ls - 1;
            while (l < ls && s.charAt(l) == t.charAt(l)) {
                l++;
            }
            while (r >= 0 && s.charAt(r) == t.charAt(r)) {
                r--;
            }
            if (l == r) return true;
        } else {
            String big = null;
            String small = null;
            if (ls > lt) {
                small = t;
                big = s;
            }else {
                small = s;
                big = t;
            }
            int l = 0;
            while (l < small.length() && s.charAt(l) == t.charAt(l)) {
                l++;
            }
            if (l == small.length()) return true;
            return big.substring(l + 1).equals(small.substring(l));
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String161_isOneEditDistance obj = new String161_isOneEditDistance();
        long start = System.currentTimeMillis();
        Object o = obj.isOneEditDistance("11", "01");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}