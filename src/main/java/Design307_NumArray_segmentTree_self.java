public class Design307_NumArray_segmentTree_self {
    int[] nums;
    int[] segmentTree;

    public Design307_NumArray_segmentTree_self(int[] nums) {
        this.nums = nums;
        segmentTree = new int[4 * nums.length];
        if (nums.length != 0) {
            buildTree(0, nums.length - 1, 0);
        }
    }

    private int buildTree(int start, int end, int index) {
        if (start == end) {
            return segmentTree[index] = nums[start];
        }
        int mid = start + (end - start) / 2;
        int left = buildTree(start, mid, index * 2 + 1);
        int right = buildTree(mid + 1, end, index * 2 + 2);
        return segmentTree[index] = left + right;
    }

    public void update(int i, int val) {
        update(0, nums.length - 1, 0, i, val);
    }

    private int update(int start, int end, int root, int index, int val) {
        if (start == end) {
            return segmentTree[root] = val;
        }
        int mid = start + (end - start) / 2;
        int leftIndex = root * 2 + 1, rightIndex = root * 2 + 2;
        if (index <= mid) {
            update(start, mid, leftIndex, index, val);
        } else {
            update(mid + 1, end, rightIndex, index, val);
        }
        return segmentTree[root] = segmentTree[leftIndex] + segmentTree[rightIndex];

    }

    public int sumRange(int i, int j) {
        return sumRange(0, nums.length - 1, i, j, 0);
    }

    private int sumRange(int start, int end, int i, int j, int root) {
        if (start == i && end == j) {
            return segmentTree[root];
        }
        int mid = start + (end - start) / 2;
        int leftIndex = root * 2 + 1, rightIndex = root * 2 + 2;
        if (i >= mid + 1) {
            return sumRange(mid + 1, end, i, j, rightIndex);
        } else if (j <= mid) {
            return sumRange(start, mid, i, j, root * 2 + 1);
        } else {
            return sumRange(start, mid, i, mid, leftIndex) + sumRange(mid + 1, end, mid + 1, j, rightIndex);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design307_NumArray_segmentTree_self obj = new Design307_NumArray_segmentTree_self(new int[]{});
//        Design307_NumArray_segmentTree_self obj = new Design307_NumArray_segmentTree_self(new int[]{1, 2, 3, 4});
        obj.update(3, 100);
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                System.out.println(i + "," + j);
                System.out.println(obj.sumRange(i, j));
            }
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}