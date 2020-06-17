import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree107_levelOrderBottom_2 {
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == res.size()) {
            res.addFirst(new ArrayList<>());
        }
        res.get(res.size() - 1 - depth).add(node.val);
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree107_levelOrderBottom_2().levelOrderBottom(treeNode);
        System.out.println(o);
    }
}