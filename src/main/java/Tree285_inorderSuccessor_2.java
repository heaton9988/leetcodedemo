import util.TreeNode;
import util.Util;

public class Tree285_inorderSuccessor_2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode ans = null;
        TreeNode cur = root;
        while (cur != null) {
            if (p.val >= cur.val) {
                cur = cur.right;
            } else {
                ans = cur;
                cur = cur.left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        for (int i = 2; i < 7; i++) {
            TreeNode o = new Tree285_inorderSuccessor_2().inorderSuccessor(treeNode, new TreeNode(i));
            System.out.println(o == null ? "null" : o.val);
        }
    }
}