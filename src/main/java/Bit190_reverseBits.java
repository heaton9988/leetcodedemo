public class Bit190_reverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int bit = 31;
        for (int i = 0; i < 32; i++) {
            res += (n & 1) << bit;
            n = n >> 1;
            bit--;
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Bit190_reverseBits obj = new Bit190_reverseBits();
        System.out.println(obj.reverseBits(0b00000010100101000001111010011100)); // 964176192
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}