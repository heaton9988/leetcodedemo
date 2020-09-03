public class Design307_NumArray_segmentTree_treeNode {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        Design307_NumArray_segmentTree_treeNode obj = new Design307_NumArray_segmentTree_treeNode(new int[]{});
        Design307_NumArray_segmentTree_treeNode obj = new Design307_NumArray_segmentTree_treeNode(new int[]{1, 2, 3, 4});
        obj.update(3, 100);
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                System.out.println(i + "," + j);
                System.out.println(obj.sumRange(i, j));
            }
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    static class SegmentTreeNode {
        int sum, start, end;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    SegmentTreeNode root;
    int[] nums;

    public Design307_NumArray_segmentTree_treeNode(int[] nums) {
        this.nums = nums;
        if (nums.length != 0) {
            root = buildTree(0, nums.length - 1);
        }
    }

    private SegmentTreeNode buildTree(int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = buildTree(start, mid);
        node.right = buildTree(mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public void update(int i, int val) {
        update(0, nums.length - 1, root, i, val);
    }

    private void update(int start, int end, SegmentTreeNode node, int index, int val) {
        if (start == end) {
            if (start == index) {
                node.sum = val;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(start, mid, node.left, index, val);
        } else {
            update(mid + 1, end, node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(0, nums.length - 1, i, j, root);
    }

    private int sumRange(int start, int end, int i, int j, SegmentTreeNode node) {
        if (start == i && end == j) {
            return node.sum;
        }
        int mid = start + (end - start) / 2;
        if (i > mid) {
            return sumRange(mid + 1, end, i, j, node.right);
        } else if (j <= mid) {
            return sumRange(start, mid, i, j, node.left);
        } else {
            return sumRange(start, mid, i, mid, node.left) + sumRange(mid + 1, end, mid + 1, j, node.right);
        }
    }
}