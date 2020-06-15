public class Math172_trailingZeroes {
    public int trailingZeroes(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            Object o = new Math172_trailingZeroes().trailingZeroes(i);
            System.out.println(i + "\t" + o);
        }
    }
}