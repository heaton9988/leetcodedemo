public class String392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) return true;
        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == cs[index]) {
                index++;
                if (index == n) return true;
            }
        }
        return index >= n;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String392_isSubsequence().isSubsequence("axc", "ahbgdc");
        Object o = new String392_isSubsequence().isSubsequence("abc", "ahbgdc");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}