public class Math029_divide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        int result = 0;
        int sign = 1;
        long a = dividend, b = divisor;
        if (dividend < 0) {
            a = -1L * dividend;
            sign *= -1;
        }
        if (divisor < 0) {
            b = -1L * divisor;
            sign *= -1;
        }
        while (a >= b) {
            a -= b;
            result += 1;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math029_divide().divide(Integer.MIN_VALUE, 2);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}