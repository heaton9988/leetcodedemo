public class Design307_NumArray_segmentTree_binaryIndexTree {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        Design307_NumArray_segmentTree_treeNode obj = new Design307_NumArray_segmentTree_treeNode(new int[]{});
        Design307_NumArray_segmentTree_binaryIndexTree obj = new Design307_NumArray_segmentTree_binaryIndexTree(new int[]{1, 2, 3, 4});
        obj.update(3, 100);
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                System.out.println(i + "," + j);
                System.out.println(obj.sumRange(i, j));
            }
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    int[] nums;
    int[] tree;

    public Design307_NumArray_segmentTree_binaryIndexTree(int[] nums) {
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