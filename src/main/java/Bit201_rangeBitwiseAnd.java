public class Bit201_rangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Bit201_rangeBitwiseAnd obj = new Bit201_rangeBitwiseAnd();
        System.out.println(obj.rangeBitwiseAnd(9, 12));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}