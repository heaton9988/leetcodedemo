import util.TreeNode;
import util.Util;

public class Tree098_isValidBST_inorder {
    Integer lastNumber = null;
    Boolean result = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null || !result) return;

        dfs(node.left);
        if (lastNumber == null || lastNumber < node.val) {
            lastNumber = node.val;
            dfs(node.right);
        } else {
            result = false;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{2, 1, 1});
        Object o = new Tree098_isValidBST_inorder().isValidBST(treeNode);
        System.out.println(o);
    }
}