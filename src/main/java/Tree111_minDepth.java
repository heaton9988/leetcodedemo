import util.TreeNode;
import util.Util;

import java.util.LinkedList;

public class Tree111_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList();
        int minDepth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            minDepth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return minDepth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree111_minDepth().minDepth(treeNode);
        System.out.println(o);
    }
}