public class Fib {
    public int fib1(int n) {
        if (n > 2) {
            return fib1(n - 1) + fib1(n - 2);
        } else {
            return 1;
        }
    }

    private static int N = 120;
    long[] fibValues = new long[N + 1];

    public long fib2(int n) {
        if (n > 2) {
            long fibV1 = fibValues[n - 1];
            long fibV2 = fibValues[n - 2];
            if (fibV1 == 0) {
                fibV1 = fib2(n - 1);
            }
            if (fibV2 == 0) {
                fibV2 = fib2(n - 2);
            }
            if (fibValues[n] == 0) {
                fibValues[n] = fibV1 + fibV2;
            }
            return fibV1 + fibV2;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        for (int i = 1; i < N; i++) {
            System.out.println(new Fib().fib2(N));
//        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}