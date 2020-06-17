import util.TreeNode;
import util.Util;

public class Tree098_isValidBST_dfs {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer greaterThan, Integer lessThan) {
        if (node == null) return true;
        if (greaterThan != null && node.val <= greaterThan) return false;
        if (lessThan != null && node.val >= lessThan) return false;
        return helper(node.left, greaterThan, node.val) && helper(node.right, node.val, lessThan);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{2, 1, 1});
        Object o = new Tree098_isValidBST_dfs().isValidBST(treeNode);
        System.out.println(o);
    }
}