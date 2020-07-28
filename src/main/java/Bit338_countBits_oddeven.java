public class Bit338_countBits_oddeven {
    int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            if (i % 2 == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Bit338_countBits_oddeven obj = new Bit338_countBits_oddeven();
        System.out.println(obj.countBits(3));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}