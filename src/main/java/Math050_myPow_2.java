public class Math050_myPow_2 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math050_myPow_2().myPow(2, -2);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}