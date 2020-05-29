public class String171_titleToNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        char cs[] = s.toCharArray();
        int n = cs.length;
        int multiply = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum += multiply * (cs[i] - 'A' + 1);
            multiply *= 26;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String171_titleToNumber().titleToNumber("AA");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}