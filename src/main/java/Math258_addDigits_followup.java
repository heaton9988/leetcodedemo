public class Math258_addDigits_followup {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    // 参考 https://leetcode-cn.com/problems/add-digits/solution/san-bu-qing-song-li-jie-o1-by-data-t/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math258_addDigits_followup().addDigits(38);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}