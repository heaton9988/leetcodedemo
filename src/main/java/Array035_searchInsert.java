public class Array035_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Array035_searchInsert obj = new Array035_searchInsert();
        System.out.println(obj.searchInsert(new int[]{1, 3, 5, 6}, 2));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}