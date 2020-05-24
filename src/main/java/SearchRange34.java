public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        Integer leftIndex = null;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                leftIndex = m;
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (leftIndex == null) leftIndex = -1;

        l = 0;
        r = n - 1;
        Integer rightIndex = null;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                rightIndex = m;
                l = m + 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (rightIndex == null) rightIndex = -1;

        return new int[]{leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SearchRange34 obj = new SearchRange34();
        System.out.println(obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}