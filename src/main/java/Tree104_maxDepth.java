import util.TreeNode;
import util.Util;

import java.util.LinkedList;

public class Tree104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int lastDepth) {
        if (node == null) return lastDepth;
        return Math.max(dfs(node.left, lastDepth + 1), dfs(node.right, lastDepth + 1));
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree104_maxDepth().maxDepth(treeNode);
        System.out.println(o);
    }
}