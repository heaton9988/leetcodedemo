import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode curr, List<Integer> res) {
        if (curr == null) return;
        helper(curr.left, res);
        helper(curr.right, res);
        res.add(curr.val);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, null, 2, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});

        Object o = new Tree145_postorderTraversal().postorderTraversal(treeNode);
        System.out.println(o);
    }
}