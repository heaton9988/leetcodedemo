import util.TreeNode;
import util.Util;

public class Tree250_countUnivalSubtrees {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    private boolean helper(TreeNode node) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            res++;
            return true;
        }
        boolean isUnival = true;
        if (node.left != null) {
            if (!helper(node.left)) isUnival = false;
            if (node.val != node.left.val) isUnival = false;
        }
        if (node.right != null) {
            if (!helper(node.right)) isUnival = false;
            if (node.val != node.right.val) isUnival = false;
        }
        if (isUnival) res++;
        return isUnival;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 1, 5, 5, 5, null, 5});
        Object o = new Tree250_countUnivalSubtrees().countUnivalSubtrees(treeNode);
        System.out.println(o);
    }
}