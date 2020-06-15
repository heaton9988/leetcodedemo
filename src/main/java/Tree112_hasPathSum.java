import util.TreeNode;
import util.Util;

public class Tree112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode node, int preSum, int sum) {
        if (node == null) return false;
        preSum = preSum + node.val;
        if (node.left == null && node.right == null) {
            if (preSum == sum) {
                return true;
            } else {
                return false;
            }
        } else {
            if (helper(node.left, preSum, sum)) {
                return true;
            } else if (helper(node.right, preSum, sum)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 1});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1,2,3});
        Object o = new Tree112_hasPathSum().hasPathSum(treeNode, 22);
        System.out.println(o);
    }
}