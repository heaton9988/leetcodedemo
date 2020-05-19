public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left2right = new int[n], right2left = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                max = nums[i];
            } else {
                max = Math.max(max, nums[i]);
            }
            left2right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                max = nums[i];
            } else {
                max = Math.max(max, nums[i]);
            }
            right2left[i] = max;
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i < res.length; i++) {
            if (i % k == 0) {
                res[i] = left2right[i + k - 1];
            } else {
                res[i] = Math.max(right2left[i], left2right[i + k - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MaxSlidingWindow239 obj = new MaxSlidingWindow239();
        int[] result = obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        int[] result = obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}