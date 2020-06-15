import util.TreeNode;
import util.Util;

public class Tree101_isSymmetric_recursion {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Object o = new Tree101_isSymmetric_recursion().isSymmetric(treeNode);
        System.out.println(o);
    }
}