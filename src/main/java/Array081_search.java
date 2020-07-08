public class Array081_search {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        outer:
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[right] == target) {
                return true;
            } else if (mid == left) {
                return false;
            }

            while (nums[mid] == nums[right]) {
                right--;
                continue outer;
            }
            while (nums[mid] == nums[left]) {
                left++;
                continue outer;
            }

            if (nums[mid] > nums[left]) {
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
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Array081_search obj = new Array081_search();
//        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(obj.search(new int[]{1, 1, 3, 1}, 3));
        System.out.println(obj.search(new int[]{3, 1, 1}, 3));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}