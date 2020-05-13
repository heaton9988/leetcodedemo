public class IncreasingTriplet334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num <= first) first = num;
            else if (num <= second) second = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 2, 3};
        IncreasingTriplet334 obj = new IncreasingTriplet334();
        long start = System.currentTimeMillis();
        System.out.println(obj.increasingTriplet(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}