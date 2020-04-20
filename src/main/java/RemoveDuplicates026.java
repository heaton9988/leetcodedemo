public class RemoveDuplicates026 {
    public int removeDuplicates(int[] nums) {
        int writeIndex = 1;
        int ret = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex++] = nums[i];
            } else {
                ret--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        RemoveDuplicates026 obj = new RemoveDuplicates026();
        long start = System.currentTimeMillis();
        int i = obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}