public class Math066_plusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math066_plusOne().plusOne(new int[]{8, 9});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}