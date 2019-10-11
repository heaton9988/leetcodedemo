import java.util.ArrayList;

public class LongestPalindrome3 {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen == 0) return "";
        char[] charArr = s.toCharArray();

        String maxWord = null;
        int maxLength = 0;

        ArrayList<int[]> ijs = new ArrayList<>(sLen * 2);
        for (int i = 0; i < sLen; i++) {
            ijs.add(new int[]{i, i});
            if (i + 1 < sLen) {
                if (charArr[i] == charArr[i + 1]) {
                    ijs.add(new int[]{i, i + 1});
                }
            }
        }
        for (int x = 0; x < sLen; x++) {
            boolean hasNewInThisLoop = false;
            ArrayList<int[]> ijsNew = new ArrayList<>(ijs.size());
            for (int[] ij : ijs) {
                int a = ij[0] - 1;
                int b = ij[1] + 1;
                if (a >= 0 && b < sLen && charArr[a] == charArr[b]) {
                    hasNewInThisLoop = true;
                    ijsNew.add(new int[]{a, b});
                }
            }
            if (hasNewInThisLoop) {
                ijs = ijsNew;
            } else {
                break;
            }
        }

        for (int[] ij : ijs) {
            if (ij[1] - ij[0] + 1 > maxLength) {
                maxLength = ij[1] - ij[0] + 1;
                maxWord = s.substring(ij[0], ij[1] + 1);
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4000; i++) {
            sb.append("a");
        }
        String s = sb.toString();

//        s = "abcba";

        long start = System.currentTimeMillis();
        String result = new LongestPalindrome3().longestPalindrome(s);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}