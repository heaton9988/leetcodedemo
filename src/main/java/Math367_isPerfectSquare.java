public class Math367_isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int l = 2, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mValue = mid * mid;
            if (mValue == num) return true;
            if (mValue > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {

            Object o = new Math367_isPerfectSquare().isPerfectSquare(i);

            System.out.println(i + "\t" + o);
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}