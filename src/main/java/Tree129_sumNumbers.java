import util.TreeNode;
import util.Util;

public class Tree129_sumNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int preSum) {
        if (node == null) return 0;
        preSum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return preSum;
        }
        return dfs(node.left, preSum) + dfs(node.right, preSum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{4, 9, 0, 5, 1});
        Object o = new Tree129_sumNumbers().sumNumbers(treeNode);
        System.out.println(o);
    }
}