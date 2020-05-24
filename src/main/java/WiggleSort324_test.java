import java.util.Arrays;

public class WiggleSort324_test {
    // time: O(n), space: O(1)
    public void wiggleSort(int[] nums) {
        int mid = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, right = n - 1;
        int index = 0;
        while (index <= right) {
            if (nums[newIndex(index, n)] > mid) {
                swap(nums, newIndex(left++, n), newIndex(index++, n));
            } else if (nums[newIndex(index, n)] < mid) {
                swap(nums, newIndex(right--, n), newIndex(index, n));
            } else {
                index++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        WiggleSort324_test obj = new WiggleSort324_test();
        obj.wiggleSort(new int[]{7, 5, 2, 6, 3, 1, 4}); // 1,5,2,6,3,7,4     0,2,4   4,5,6

//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}