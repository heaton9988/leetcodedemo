public class MaxArea011 {
    public int maxArea(int[] height) {
        int res = 0, tmp = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            if (tmp > res) res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea011 obj = new MaxArea011();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxArea(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}