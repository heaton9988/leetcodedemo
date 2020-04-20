public class RemoveElement027 {
    public int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex++] = nums[i];
            } else {
                ret--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        RemoveElement027 obj = new RemoveElement027();
        long start = System.currentTimeMillis();
        int i = obj.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}