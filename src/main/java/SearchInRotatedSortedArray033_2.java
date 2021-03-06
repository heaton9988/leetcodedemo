public class SearchInRotatedSortedArray033_2 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return bSearch(nums, 0, nums.length - 1, target);
    }

    private int bSearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < nums[right]) { // 右半边正常
            if (target > nums[mid] && target <= nums[right]) { // 大于right的数字, 有可能存在, 在左边
                return bSearch(nums, mid + 1, right, target);
            } else {
                return bSearch(nums, left, mid - 1, target);
            }
        } else if (nums[mid] >= nums[left]) { // 右半边不正常 &&
            if (target < nums[mid] && target >= nums[left]) {
                return bSearch(nums, left, mid - 1, target);
            } else {
                return bSearch(nums, mid + 1, right, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] prices = new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}};
        int[] prices = new int[]{1, 3, 5};
        int target = 3;
        SearchInRotatedSortedArray033_2 obj = new SearchInRotatedSortedArray033_2();
        long start = System.currentTimeMillis();

        System.out.println(obj.search(prices, target));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}