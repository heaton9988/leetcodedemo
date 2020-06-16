import util.TreeNode;
import util.Util;

public class Tree110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, null, 20, null, null, 15, 7});
        Object o = new Tree110_isBalanced().isBalanced(treeNode);
        System.out.println(o);
    }
}