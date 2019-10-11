public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int ret[] = new int[len];

        int productAllLeft = 1;
        int productAllRight = 1;
        int[] productLeft = new int[len];
        productLeft[0] = 1;
        int[] productRight = new int[len];
        productRight[len - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            productAllLeft *= nums[i - 1];
            productLeft[i] = productAllLeft;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            productAllRight *= nums[i + 1];
            productRight[i] = productAllRight;
        }

        for (int i = 0; i < nums.length; i++) {
            ret[i] = productLeft[i] * productRight[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        ProductExceptSelf238 obj = new ProductExceptSelf238();
        long start = System.currentTimeMillis();
        int[] ints = obj.productExceptSelf(prices);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}