public class SegmentTreeByTreeNode {
    public static void main(String[] args) {
        SegmentTreeByTreeNode obj = new SegmentTreeByTreeNode(new int[]{1, 2, 3, 4});
        obj.update(3, 100);
        System.out.println(obj.sumRange(1, 3));
    }

    SegmentTreeNode root;
    int[] nums;

    public SegmentTreeByTreeNode(int[] nums) {
        this.nums = nums;
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        if (start == end) {
            cur.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = cur.left.sum + cur.right.sum;
        }
        return cur;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode cur, int pos, int val) {
        if (cur.start == cur.end) {
            cur.sum = val;
            return;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        if (pos <= mid) {
            update(cur.left, pos, val);
        } else {
            update(cur.right, pos, val);
        }
        cur.sum = cur.left.sum + cur.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode cur, int start, int end) {
        if (cur.end == end && cur.start == start) {
            return cur.sum;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        int res;
        if (end <= mid) {
            res = sumRange(cur.left, start, end);
        } else if (start >= mid + 1) {
            res = sumRange(cur.right, start, end);
        } else {
            res = sumRange(root.left, start, mid) + sumRange(cur.right, mid + 1, end);
        }
        return res;
    }

    static class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}