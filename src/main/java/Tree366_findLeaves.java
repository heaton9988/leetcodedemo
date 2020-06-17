import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree366_findLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        while (root.left != null || root.right != null) {
            LinkedList<Integer> temp = new LinkedList<>();
            dfs(root, temp);
            res.add(temp);
        }
        res.add(Arrays.asList(root.val));
        return res;
    }

    private boolean dfs(TreeNode node, List<Integer> temp) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            temp.add(node.val);
            return true;
        }
        if (dfs(node.left, temp)) {
            node.left = null;
        }
        if (dfs(node.right, temp)) {
            node.right = null;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5});
        Object o = new Tree366_findLeaves().findLeaves(treeNode);
        System.out.println(o);
    }
}