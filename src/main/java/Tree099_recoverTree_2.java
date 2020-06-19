import util.TreeNode;
import util.Util;

public class Tree099_recoverTree_2 {
    TreeNode x = null, y = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre != null && node.val < pre.val) {
            if (x == null) x = pre;
            y = node;
        }
        pre = node;
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{2, 3, 1});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{7, 2, 6, 1, 3, 5, 4});
        new Tree099_recoverTree_2().recoverTree(treeNode);
        System.out.println();
    }
}