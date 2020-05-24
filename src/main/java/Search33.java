public class Search33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[right] == target) {
                return right;
            } else if (mid == left) {
                return -1;
            }

            if (nums[mid] == nums[left]) {

            } else if (nums[mid] > nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Search33 obj = new Search33();
//        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(obj.search(new int[]{1, 3}, 2));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}