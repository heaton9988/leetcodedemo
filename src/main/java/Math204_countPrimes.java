import java.util.Arrays;

/**
 * 这题用dfs总是超时, bfs偏向求出最少step的解
 */
public class Math204_countPrimes {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j >= 0 && j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math204_countPrimes().countPrimes(499979);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}