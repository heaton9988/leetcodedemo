public class Math029_divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long ans;
        if (dividend < 0 && divisor < 0) {
            ans = div(-dividend, -divisor);
        } else if (dividend > 0 && divisor > 0) {
            ans = div(dividend, divisor);
        } else {
            ans = -div(Math.abs(dividend), Math.abs(divisor));
        }
        return (int) ans;
    }

    private long div(int a, int b) {
        if (a < b) return 0;
        int i = 0;
        while (a >= (b << i)) {
            i++;
        }
        i--;
        return (1 << i) + div(a - (b << i), b);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math029_divide().divide(2147483647, 2);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}