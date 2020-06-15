import util.TreeNode;
import util.Util;

public class Tree298_longestConsecutive {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1, root.val);
        return res;
    }

    private void helper(TreeNode node, int preCount, Integer lastVal) {
        if (node == null) return;
        if (node.val != lastVal + 1) {
            preCount = 1;
        } else {
            preCount += 1;
        }
        if (preCount > res) res = preCount;
        if (node.left == null && node.right == null) {
            return;
        } else {
            helper(node.left, preCount, node.val);
            helper(node.right, preCount, node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1,null,3,null,null,2,4});
        Object o = new Tree298_longestConsecutive().longestConsecutive(treeNode);
        System.out.println(o);
    }
}