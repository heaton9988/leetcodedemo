public class LongestPalindrome2 {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen == 0) return "";
        char[] charArr = s.toCharArray();
        String maxWord = null;
        int maxLength = 0;
        boolean doSubstring = false;
        for (int i = 0; i < sLen; i++) {
            // 中间无单个数
            String strMiddleNoSingle = null;
            doSubstring = false;
            int a = i, b = a + 1;
            while (a >= 0 && b < sLen) {
                if (charArr[a] != charArr[b]) {
                    break;
                } else {
                    doSubstring = true;
                    a--;
                    b++;
                }
            }
            strMiddleNoSingle = s.substring(a + 1, b);
            // 中间是单个数
            doSubstring = false;
            String strMiddleIsSingle = charArr[i] + "";
            a = i - 1;
            b = i + 1;
            while (a >= 0 && b < sLen) {
                if (charArr[a] != charArr[b]) {
                    break;
                } else {
                    doSubstring = true;
                    a--;
                    b++;
                }
            }
            if (doSubstring) {
                strMiddleIsSingle = s.substring(a + 1, b);
            }
            if (strMiddleNoSingle != null && strMiddleNoSingle.length() > maxLength) {
                maxWord = strMiddleNoSingle;
                maxLength = strMiddleNoSingle.length();
            }
            if (strMiddleIsSingle != null && strMiddleIsSingle.length() > maxLength) {
                maxWord = strMiddleIsSingle;
                maxLength = strMiddleIsSingle.length();
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            sb.append("a");
        }
        String s = sb.toString();

//        s = "abcba";

        long start = System.currentTimeMillis();
        String result = new LongestPalindrome2().longestPalindrome(s);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

//    private boolean isPalindrome(String s) {
//        if (s == null || s.trim().equals("")) {
//            return false;
//        }
//        for (int i = 0; i < s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}