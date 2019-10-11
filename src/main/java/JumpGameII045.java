public class JumpGameII045 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0, index = 0;
        while (true) {
            if (index + nums[index] >= nums.length - 1) {
                return 1 + step;
            }
            int maxTarget = 0, nextIndex = 0;
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (i + nums[i] > maxTarget) {
                    maxTarget = i + nums[i];
                    nextIndex = i;
                }
            }
            index = nextIndex;
            step++;
        }
    }

    public static void main(String[] args) {
        JumpGameII045 obj = new JumpGameII045();
        long start = System.currentTimeMillis();
        System.out.println(obj.jump(new int[]{1, 2, 3}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}