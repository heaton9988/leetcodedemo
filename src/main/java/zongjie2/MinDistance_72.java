package zongjie2;

public class MinDistance_72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一列
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        // 第一行
        for (int i = 0; i <= n2; i++) dp[0][i] = i;

        print(dp);
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                print(dp);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        print(dp);

        return dp[n1][n2];
    }

    private void print(int[][] dp) {
        StringBuilder sb = new StringBuilder("\n");
        for (int[] d : dp) {
            for (int num : d) {
                sb.append(num).append(" , ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        MinDistance_72 obj = new MinDistance_72();
        long start = System.currentTimeMillis();
        Object res = obj.minDistance("horse", "ros");
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}