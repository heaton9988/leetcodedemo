public class Math258_addDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math258_addDigits().addDigits(38);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}