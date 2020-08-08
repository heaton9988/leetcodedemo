/**
 * 设计难点:
 * 1. 合并N个链表, 输出前10个最小的值
 * 2. timestamp用int的形式表达出来, 用时间戳的话, 占用的空间比较大, 而且容易出错, 并且找不到原因
 * 3. 用链表更好, 用数组的话, 每次添加到0的位置, 后面的元素都需要往后移动, 性能耗费较大
 */
public class Design303_NumArray {
    int[] sums;

    public Design303_NumArray(int[] nums) {
        int sum = 0;
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        int right = sums[j];
        int left = 0;
        if (i > 0) {
            left = sums[i - 1];
        }
        return right - left;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design303_NumArray obj = new Design303_NumArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(obj.sumRange(0,3));
        System.out.println(obj.sumRange(1,3));
        System.out.println(obj.sumRange(2,3));
        System.out.println(obj.sumRange(3,3));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}