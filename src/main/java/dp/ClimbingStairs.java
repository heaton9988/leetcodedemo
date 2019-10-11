package dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

//        if(n==1)return 1;
//        if(n==2)return 2;
//        if(n==3)return 3;
//        if(n==4)return 5;
//        if(n==5)return 8;
//        if(n==6)return 13;


    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        long start = System.currentTimeMillis();
        int result = obj.climbStairs(5);
        System.out.println("cost " + (System.currentTimeMillis() - start));
        System.out.println(result);
    }
}
