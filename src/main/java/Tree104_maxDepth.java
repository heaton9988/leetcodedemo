import util.TreeNode;
import util.Util;

import java.util.LinkedList;

public class Tree104_maxDepth {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode node, int lastDepth) {
        if (node == null) return;
        lastDepth++;
        if (lastDepth > max) max = lastDepth;
        dfs(node.left, lastDepth);
        dfs(node.right, lastDepth);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree104_maxDepth().maxDepth(treeNode);
        System.out.println(o);
    }
}