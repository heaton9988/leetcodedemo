public class CanJump055 {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump055 obj = new CanJump055();
        long start = System.currentTimeMillis();

        Object v = obj.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}