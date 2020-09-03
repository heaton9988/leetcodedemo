public class BinaryIndexTree {
    public static void main(String[] args) {
        BinaryIndexTree obj = new BinaryIndexTree(new int[]{1, 2, 3, 4});
        obj.update(3, 100);
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                System.out.println(i + "," + j);
                System.out.println(obj.sumRange(i, j));
            }
        }
    }

    int[] nums;
    int[] tree;

    public BinaryIndexTree(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= nums.length; j += j & (-j)) {
            tree[j] += diff;
//            System.out.println(j + " " + (-j) + " " + Integer.toBinaryString(-j) + " " + (j & (-j)));
        }
//        System.out.println(Arrays.toString(tree));
    }

    public int sumRange(int i, int j) {
        return sumRange(j + 1) - sumRange(i);
    }

    private int sumRange(int k) {
        int res = 0;
        for (int i = k; i > 0; i -= (i & -i)) {
            res += tree[i];
        }
        return res;
    }
}