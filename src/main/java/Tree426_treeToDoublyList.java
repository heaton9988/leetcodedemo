import util.TreeNode;
import util.Util;

public class Tree426_treeToDoublyList {
    // the smallest (first) and the largest (last) nodes
    TreeNode first = null;
    TreeNode last = null;

    public void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);
        // node
        if (last != null) {
            // link the previous node (last)
            // with the current one (node)
            last.right = node;
            node.left = last;
        } else {
            // keep the smallest node
            // to close DLL later on
            first = node;
        }
        last = node;

        helper(node.right);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{4, 2, 5, 1, 3});
        Object o = new Tree426_treeToDoublyList().treeToDoublyList(treeNode);
        System.out.println(o);
    }
}
