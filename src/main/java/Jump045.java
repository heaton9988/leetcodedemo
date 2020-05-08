public class Jump045 {

    public int jump(int[] nums) {
        int end = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int lastEnd = end;
            if (end >= nums.length - 1) break;
            for (int j = i; j <= lastEnd && j < nums.length; j++) {
                end = Math.max(end, j + nums[j]);
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Jump045 obj = new Jump045();
        long start = System.currentTimeMillis();

        Object v = obj.jump(new int[]{2, 2, 2, 2, 2});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}