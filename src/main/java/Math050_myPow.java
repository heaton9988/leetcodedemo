public class Math050_myPow {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) return x;
        if (n == 0) return 1;
        long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = Math.abs(pow);
        }

        double half = myPow(x, (int) (pow / 2));
        if (pow % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math050_myPow().myPow(2, -2);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}