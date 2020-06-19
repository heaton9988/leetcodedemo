import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Tree099_recoverTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null, y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                if (x == null) {
                    x = list.get(i);
                }
                y = list.get(i + 1);
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{7, 2, 6, 1, 3, 5, 4});
        new Tree099_recoverTree().recoverTree(treeNode);
        System.out.println();
    }
}