package zongjie1;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while ( sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] param = {2, 3, 1, 2, 4, 3};
        Object o = new MinSubArrayLen209().minSubArrayLen(7, param);
        System.out.println(o);
    }
}
