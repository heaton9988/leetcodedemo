import util.Util;

import java.util.Random;

public class Random398_randomIndex {
    private int[] nums;

    public Random398_randomIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target) {
                //我们的目标对象中选取。
                n++;
                //我们以1/n的概率留下该数据
                if (r.nextInt() % n == 0) {
                    index = i;
                }
            }
        return index;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random398_randomIndex obj = new Random398_randomIndex(new int[]{1, 2, 3, 3, 3});
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.pick(3));
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}