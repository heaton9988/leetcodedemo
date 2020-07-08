public class Array153_findMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (l == r) {
                return nums[l];
            } else if (l + 1 == r) {
                return Math.min(nums[l], nums[r]);
            }
            int mid = l + (r - l) / 2; // mid不可能等于l和r
            if (nums[l] < nums[mid]) {
                if (nums[mid] < nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Array153_findMin obj = new Array153_findMin();
        System.out.println(obj.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}