public class Bit260_singleNumber {
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        // 上面等价于: 把两个数的每位的区别用1表示, 相同的用0表示(异或操作)

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);// 找出第1个1, 也就是3和5的第一个不同值的位

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) {
            if ((num & diff) != 0) { // 3和5只有一个数会进来, 其他重复两次的值要么全进来 ,要么都不进来, 所以无所谓
                x ^= num;
            }
        }
        return new int[]{x, bitmask ^ x};
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Bit260_singleNumber obj = new Bit260_singleNumber();
        System.out.println(obj.singleNumber(new int[]{3, 5, 1, 1, 2, 2})); // 964176192
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}