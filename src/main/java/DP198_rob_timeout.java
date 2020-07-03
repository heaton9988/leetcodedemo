public class DP198_rob_timeout {
    int[] nums;
    int size;

    public int rob(int[] nums) {
        this.nums = nums;
        size = nums.length;
        if (size == 0) return 0;
        return Math.max(max(0, true), max(0, false));
    }

    private int max(int index, boolean steal) {
        int sum = steal ? nums[index] : 0;
        if (index < size - 1) {
            int nextSum;
            if (steal) {
                nextSum = max(index + 1, false);
            } else {
                nextSum = Math.max(max(index + 1, false), max(index + 1, true));
            }
            sum += nextSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP198_rob_timeout().rob(new int[]{1, 2, 3, 1});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}