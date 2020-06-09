public class Math069_mySqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long l = 1, r = x / 2;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long mm = m * m;
            long m1m1 = (m + 1) * (m + 1);
            if (mm == x) return (int) m;
            if (m1m1 == x) return (int) m + 1;
            if (mm < x && m1m1 > x) return (int) m;
            if (m1m1 < x) {
                l = m + 1;
            }
            if (mm > x) {
                r = m - 1;
            }
        }
        return (int) r;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math069_mySqrt().mySqrt(5);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}