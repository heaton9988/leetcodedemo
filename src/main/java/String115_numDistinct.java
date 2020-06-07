import java.util.Arrays;

public class String115_numDistinct {
    public int numDistinct(String s, String t) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);
        int lastlastJ1 = 1;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < dp.length; j++) {
                int lastJ1 = dp[j];
                if (j == 0) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j - 1];
                    if (s.charAt(j - 1) == t.charAt(i)) {
                        dp[j] += lastlastJ1;
                    }
                }
                lastlastJ1 = lastJ1;
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String115_numDistinct().numDistinct("baggg", "bagg");
        Object o = new String115_numDistinct().numDistinct("babgbag", "bag");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}