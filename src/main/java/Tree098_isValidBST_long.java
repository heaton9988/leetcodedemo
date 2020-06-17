import util.TreeNode;
import util.Util;

public class Tree098_isValidBST_long {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper(TreeNode node, long lessThan, long greaterThan) {
        if (node == null) {
            return true;
        }
        if (node.val >= greaterThan && node.val <= lessThan) {
            return helper(node.left, node.val - 1, greaterThan)
                    && helper(node.right, lessThan, node.val + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{2, 1, 1});
        Object o = new Tree098_isValidBST_long().isValidBST(treeNode);
        System.out.println(o);
    }
}