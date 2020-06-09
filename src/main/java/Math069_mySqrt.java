public class Math069_mySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math069_mySqrt().mySqrt(5);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}