import util.TreeNode;
import util.Util;

public class Tree333_largestBSTSubtree_2 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (judge(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return get(root);
        }
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left, right);
    }

    private boolean judge(TreeNode root, int upper, int low) {
        if (root == null) return true;
        return root.val > low && root.val < upper && judge(root.left, root.val, low) && judge(root.right, upper, root.val);
    }

    private int get(TreeNode root) {
        return root == null ? 0 : get(root.left) + get(root.right) + 1;
    }

    public static void main(String[] args) {
//        Object o = new Tree333_largestBSTSubtree_2().largestBSTSubtree(Util.arr2tree(10, 5, 15, 1, 8, null, 7));
//        Object o = new Tree333_largestBSTSubtree_2().largestBSTSubtree(Util.arr2tree(3,2,4,null,null,1));
        Object o = new Tree333_largestBSTSubtree_2().largestBSTSubtree(Util.arr2tree(2, 3, null, 1));
//        Object o = new Tree333_largestBSTSubtree_2().largestBSTSubtree(Util.arr2tree(4, 2, 7, 2, 3, 5, null, 2, null, null, null, null, null, null, null, 1));
        System.out.println(o);
    }
}