public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1, data = m + n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                nums1[data--] = nums1[left--];
            } else {
                nums1[data--] = nums2[right--];
            }
        }
        while (left >= 0) {
            nums1[data--] = nums1[left--];
        }
        while (right >= 0) {
            nums1[data--] = nums2[right--];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Merge88 obj = new Merge88();
        obj.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}