import java.util.Arrays;

public class WiggleSort324_leetcode {
    // time: O(nlogn), space: O(n)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n - 1) / 2;
        int index = 0;
        int[] temp = new int[n];
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i];
            if (index + 1 < n) {
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
        System.out.println();
    }

    // time: O(n), space: O(1)
    public void wiggleSort2(int[] nums) {
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

    // time: O(nlogn), space: O(n)
    public void wiggleSort3(int[] nums) {
        int[] cpy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cpy[i] = nums[i];
        }

        Arrays.sort(cpy);
        int m = (nums.length + 1) / 2;

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) {
            nums[j] = cpy[i];
            System.out.println(j + " " + i);
        }
        for (int i = nums.length - 1, j = 1; i >= m; i--, j += 2) {
            nums[j] = cpy[i];
            System.out.println(j + " - " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        WiggleSort324_leetcode obj = new WiggleSort324_leetcode();
        obj.wiggleSort(new int[]{1, 5, 2, 6, 3, 7, 4}); // 1,5,2,6,3,7,4     0,2,4   4,5,6

//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}