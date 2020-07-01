public class DP375_getMoneyAmount {
    public int calculate(int low, int high) {
        if (low >= high) {
            return 0;
        }
        int minres = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }
        return minres;
    }

    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP375_getMoneyAmount().getMoneyAmount(10);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}