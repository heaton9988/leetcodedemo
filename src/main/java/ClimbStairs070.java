import java.util.PriorityQueue;

public class ClimbStairs070 {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = n1 + n2;
            n1 = n2;
            n2 = curr;
        }

        return n2;
    }

    public static void main(String[] args) {

        //You may assume that nums' length ≥ k-1 and k ≥ 1.
        ClimbStairs070 obj = new ClimbStairs070();
        long start = System.currentTimeMillis();
        int i = obj.climbStairs(4);
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}