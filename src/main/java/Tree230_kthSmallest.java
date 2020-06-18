import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree230_kthSmallest {
    Integer result = null;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (result != null || node == null) return;
        helper(node.left);
        if (--k == 0) {
            result = node.val;
            return;
        }
        helper(node.right);
    }

    public static void main(String[] args) {
        Object o = new Tree230_kthSmallest().kthSmallest(Util.arr2tree(3, 1, 4, null, 2), 2);
        System.out.println(o);
    }
}