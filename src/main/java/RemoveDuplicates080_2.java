public class RemoveDuplicates080_2 {
    public int removeDuplicates(int[] nums) {
        int writeIndex = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicates080_2 obj = new RemoveDuplicates080_2();
        long start = System.currentTimeMillis();
        int i = obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}