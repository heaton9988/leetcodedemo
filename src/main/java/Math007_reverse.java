public class Math007_reverse {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String115_numDistinct().numDistinct("baggg", "bagg");
        Object o = new Math007_reverse().reverse(123);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}