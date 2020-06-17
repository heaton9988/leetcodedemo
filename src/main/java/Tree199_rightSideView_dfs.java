import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree199_rightSideView_dfs {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (depth >= res.size()) res.add(node.val);
        helper(node.right, depth + 1);
        helper(node.left, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, null, 5, null, 4});
        Object o = new Tree199_rightSideView_dfs().rightSideView(treeNode);
        System.out.println(o);
    }
}