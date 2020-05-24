public class SortColors75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        while (p0 < n && nums[p0] == 0) {
            p0++;
        }
        while (p2 >= 0 && nums[p2] == 2) {
            p2--;
        }
        for (int i = p0; i <= p2; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0++);
            }
            if (nums[i] == 2) {
                swap(nums, i--, p2--); // 为2交换的时候, i保持不动, 因为不知道什么值被替换过来了
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SortColors75 obj = new SortColors75();
        obj.sortColors(new int[]{1, 2, 0});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}