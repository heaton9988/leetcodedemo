public class DP010_isMatch_dfs {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new DP010_isMatch_dfs().isMatch("", "a*a*")); // true
        System.out.println(new DP010_isMatch_dfs().isMatch("aa", "a*")); // true
        System.out.println(new DP010_isMatch_dfs().isMatch("aa", "a")); // false
        System.out.println(new DP010_isMatch_dfs().isMatch("ab", ".*")); // true
        System.out.println(new DP010_isMatch_dfs().isMatch("aab", "c*a*b")); // true
        System.out.println(new DP010_isMatch_dfs().isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}