public class ProductExceptSelf238_2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        left[1] = nums[0];
        right[n - 1] = 1;
        right[n - 2] = nums[n - 1];
        for (int i = 2; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = n - 3; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4};
        ProductExceptSelf238_2 obj = new ProductExceptSelf238_2();
        long start = System.currentTimeMillis();
        int[] ints = obj.productExceptSelf(prices);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}