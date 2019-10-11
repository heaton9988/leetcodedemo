public class SearchInRotatedSortedArray033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;

        int smallestIndex = findSmallest(nums, 0, len - 1);
        System.out.println("smallest = " + smallestIndex);

        if (smallestIndex == 0) {
            return binarySearch(nums, 0, len - 1, target);
        } else if (target > nums[0]) {
            return binarySearch(nums, 0, smallestIndex - 1, target);
        } else if (target < nums[0]) {
            return binarySearch(nums, smallestIndex, len - 1, target);
        } else {
            return 0;
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        if (start == end) return nums[start] == target ? start : -1;

        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return binarySearch(nums, start, middle - 1, target);
        } else {
            return binarySearch(nums, middle + 1, end, target);
        }
    }

    private int findSmallest(int[] arr, int start, int end) {
        if (start > end) return -1;
        if (arr[start] <= arr[end]) return start;

        int middle = (start + end) / 2;
        if (middle + 1 < arr.length && arr[middle] > arr[middle + 1]) return middle + 1;
        if (middle - 1 >= 0 && arr[middle] < arr[middle - 1]) return middle;
        if (arr[middle] > arr[start]) {
            return findSmallest(arr, middle, end);
        } else if (arr[middle] < arr[start]) {
            return findSmallest(arr, start, middle - 1);
        } else {
            return middle;
        }
    }


    public static void main(String[] args) {
//        int[] prices = new int[]{1, 3, 5};
        int[] prices = new int[]{4, 5, 6, 7, 0, 1, 2};
//        int[] prices = new int[]{5, 1};
        int target = 3;
        SearchInRotatedSortedArray033 obj = new SearchInRotatedSortedArray033();
        long start = System.currentTimeMillis();

        System.out.println(obj.search(prices, target));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}