import util.TreeNode;
import util.Util;

public class Tree236_lowestCommonAncestor {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private int helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || result != null) return 0;

        int countLeft = helper(node.left, p, q);
        int countRight = helper(node.right, p, q);
        int countSelf = (node.val == p.val || node.val == q.val) ? 1 : 0;
        int count = countLeft + countRight + countSelf;
        if (count == 2) {
            result = node;
            return 0;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode o = new Tree236_lowestCommonAncestor().lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(1));
        System.out.println(o == null ? null : o.val);
    }
}