public class FirstMissingPositive041 {
    // 提示：
    //
    //你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = -1;
            } else if (i != nums[i] - 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    nums[i] = -1;
                } else {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == -1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive041 obj = new FirstMissingPositive041();
        long start = System.currentTimeMillis();
        int i = obj.firstMissingPositive(new int[]{1, 1});
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}