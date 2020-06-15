import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree094_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode curr, List<Integer> res) {
        if (curr == null) return;
        helper(curr.left, res);
        res.add(curr.val);
        helper(curr.right, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, null, 2, 3});
        Object o = new Tree094_inorderTraversal().inorderTraversal(treeNode);
        System.out.println(o);
    }
}