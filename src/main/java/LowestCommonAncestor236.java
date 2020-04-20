import util.TreeNode;
import util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor236 {
    TreeNode p;
    TreeNode q;
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        helper(root);
        return result;
    }

    private int helper(TreeNode curr) {
        if (curr == null || result != null) return 0;

        int count = 0;
        if (curr.val == p.val || curr.val == q.val) count++;
        count += helper(curr.left);
        count += helper(curr.right);

        if (count >= 2) {
            result = curr;
        }

        return count == 0 ? 0 : 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        LowestCommonAncestor236 obj = new LowestCommonAncestor236();
        long start = System.currentTimeMillis();
        TreeNode result = obj.lowestCommonAncestor(treeNode, new TreeNode(6), new TreeNode(8));
        System.out.println(result.val);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}