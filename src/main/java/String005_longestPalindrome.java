public class String005_longestPalindrome {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) return "";
        int start = 0, end = 0;
        for (int begin = 0; begin < n; begin++) {
            int l = begin, r = begin;

            while (r < n - 1 && cs[r + 1] == cs[l]) {
                r++;
            }
            begin = r;

            while (l > 0 && r < n - 1 && cs[l - 1] == cs[r + 1]) {
                l--;
                r++;
            }

            if (r - l > end - start) {
                start = l;
                end = r;
            }
        }
        String res = s.substring(start, end + 1);
        return res;
    }

    public static void main(String[] args) {
        Object o = new String005_longestPalindrome().longestPalindrome("babad");
        System.out.println(o);
    }
}