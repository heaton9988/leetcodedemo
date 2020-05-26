import java.util.Arrays;

public class MaxEnvelopes354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // 当宽相同的时候, 高的那个要放在前面

        int dp[] = new int[n];
        int len = 0;
        for (int[] e : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, e[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == len) len++;
            dp[index] = e[1];
        }

        return len;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{5, 4}
                , new int[]{6, 4}
                , new int[]{6, 7}
                , new int[]{2, 3}
        };
        int result = new MaxEnvelopes354().maxEnvelopes(nums);
        System.out.println(result);
    }
}