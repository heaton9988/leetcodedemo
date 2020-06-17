import util.TreeNode;
import util.Util;

import java.util.HashMap;

public class Tree337_rob_2 {
    public int rob(TreeNode root) {
        int res[] = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode node) {
        int res[] = new int[2];
        if (node != null) {
            int[] resLeft = helper(node.left);
            int[] resRight = helper(node.right);

            res[0] = Math.max(resLeft[0], resLeft[1]) + Math.max(resRight[0], resRight[1]);
            res[1] = node.val + resLeft[0] + resRight[0];
        }
        return res;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 2, 3, null, 3, null, 1});
        Object o = new Tree337_rob_2().rob(treeNode);
        System.out.println(o);
    }
}