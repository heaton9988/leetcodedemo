package zongjie1;

import java.util.Arrays;

public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] param = {1, 2, 3, 4};
        int[] o = new ProductExceptSelf238().productExceptSelf(param);
        System.out.println(Arrays.toString(o));
    }
}
