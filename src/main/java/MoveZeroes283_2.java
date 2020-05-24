public class MoveZeroes283_2 {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    // 思路：双指针方法，不等于 0，指针一同移动，两指针元素互换。
// 等到 0 的时候，左指针不动，右指针继续移动。
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MoveZeroes283_2 obj = new MoveZeroes283_2();
        obj.moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}