public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(9 ^ 9);
//        int[][] prices = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
        int[] prices = new int[]{1, 3, 3, 1, 4};
        SingleNumber136 obj = new SingleNumber136();
        long start = System.currentTimeMillis();
        System.out.println(obj.singleNumber(prices));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}