import util.TreeNode;
import util.Util;

public class Tree124_maxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (node.val > max) max = node.val;
            return node.val;
        }
        int currMaxSingle = node.val;
        int currMaxAll = node.val;
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        if (leftMax > 0 || rightMax > 0) currMaxSingle += (leftMax > rightMax ? leftMax : rightMax);
        if (leftMax > 0) currMaxAll += leftMax;
        if (rightMax > 0) currMaxAll += rightMax;
        if (currMaxSingle > max) max = currMaxSingle;
        if (currMaxAll > max) max = currMaxAll;
        return currMaxSingle;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        Object o = new Tree124_maxPathSum().maxPathSum(treeNode);
        System.out.println(o);
    }
}