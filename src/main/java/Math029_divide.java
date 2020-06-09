public class Math029_divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = dividend, b = divisor; // 必须要转成long,否则会在下面的调用中, 左边的数是min_value的时候会挂
        long ans;
        if (a < 0 && b < 0) {
            ans = div(-a, -b);
        } else if (a > 0 && b > 0) {
            ans = div(a, b);
        } else {
            ans = -div(Math.abs(a), Math.abs(b));
        }
        return (int) ans;
    }

    private long div(long a, long b) {
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