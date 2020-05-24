package mine;

import util.Util;

public class QuickFindMedian {
    //    private int find(int[] nums, int start, int end) {
//        int n = nums.length;
//        int pivot = nums[0];
//        int left = 1, right = end;
//        while (left < right) {
//            while (left < right && nums[right] > pivot) {
//                right--;
//            }
//            while (left < right && nums[left] <= pivot) {
//                left++;
//            }
//            if (left == right) break;
//            else {
//                swap(nums, left++, right--);
//            }
//        }
//        swap(nums, left, 0);
//        if (left == n / 2) {
//            return nums[left];
//        } else if (left > n / 2) {
//            return find(nums, start, left - 1);
//        } else {
//            return find(nums, left + 1, end);
//        }
//    }
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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickFindMedian obj = new QuickFindMedian();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Util.printArr(arr);
        obj.wiggleSort(arr);
        Util.printArr(arr);
    }
}