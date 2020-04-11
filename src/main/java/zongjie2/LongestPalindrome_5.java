package zongjie2;

public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                System.out.println("i=" + i + ",j=" + j);
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    String curr = s.substring(i, j + 1);
                    if (curr.length() > res.length()) {
                        res = curr;
                    }
                }
            }
        }
        return res;
    }

//    private static String print(boolean[][] arrs) {
//        for (boolean[] arr : arrs) {
//            for (boolean b : arr) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        LongestPalindrome_5 obj = new LongestPalindrome_5();
        long start = System.currentTimeMillis();
        Object res = obj.longestPalindrome("abcba");
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}