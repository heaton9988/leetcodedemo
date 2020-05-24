public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int data = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[data++] = nums[i];
            }
        }
        while (data < n) {
            nums[data++] = 0;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MoveZeroes283 obj = new MoveZeroes283();
        obj.moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}