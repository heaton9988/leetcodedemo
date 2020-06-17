import util.TreeNode;
import util.Util;

public class Tree235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode o = new Tree235_lowestCommonAncestor().lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(8));
        System.out.println(o.val);
    }
}