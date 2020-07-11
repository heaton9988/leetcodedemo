public class BinarySearch162_findPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0) {
                return nums[1] < nums[0] ? 0 : 1;
            } else if (mid == n - 1) {
                return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) { //
                r = mid - 1;
            } else if (nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BinarySearch162_findPeakElement obj = new BinarySearch162_findPeakElement();
        System.out.println(obj.findPeakElement(new int[]{1, 2, 3, 1}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}