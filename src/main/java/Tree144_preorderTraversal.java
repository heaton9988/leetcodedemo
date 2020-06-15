import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode curr, List<Integer> res) {
        if (curr == null) return;
        res.add(curr.val);
        helper(curr.left, res);
        helper(curr.right, res);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, null, 2, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});

        Object o = new Tree144_preorderTraversal().preorderTraversal(treeNode);
        System.out.println(o);
    }
}