public class FindMedianSortedArrays004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int max = 1;

        if ((m + n) % 2 == 0) {
            max = 2;
        }
        int start = (m + n - 1) / 2;
        int end = start + max - 1;
        int[] result = new int[end - start + 1];
        int resultIndex = 0;

        int i1 = 0, i2 = 0;
        while (i1 < m && i2 < n) {
            int allIndex = i1 + i2;
            boolean get = false;
            if (allIndex >= start && allIndex <= end) {
                get = true;
            }
            if (nums1[i1] < nums2[i2]) {
                if (get) result[resultIndex++] = nums1[i1];
                i1++;
            } else {
                if (get) result[resultIndex++] = nums2[i2];
                i2++;
            }
        }
        while (i1 < m) {
            int allIndex = i1 + i2;
            boolean get = false;
            if (allIndex >= start && allIndex <= end) {
                get = true;
            }
            if (get) result[resultIndex++] = nums1[i1];
            i1++;
        }
        while (i2 < n) {
            int allIndex = i1 + i2;
            boolean get = false;
            if (allIndex >= start && allIndex <= end) {
                get = true;
            }
            if (get) result[resultIndex++] = nums2[i2];
            i2++;
        }

        double sum = 0;
        int count = 0;
        for (int num : result) {
            sum += num;
            count++;
        }
        return sum / count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        FindMedianSortedArrays004 obj = new FindMedianSortedArrays004();
        long start = System.currentTimeMillis();
        System.out.println(obj.findMedianSortedArrays(arr, new int[]{2}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}