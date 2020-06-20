import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree114_flatten {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode leftNode = helper(node.left);
        TreeNode rightNode = helper(node.right);
        if (leftNode != null) {
            node.right = leftNode;
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = rightNode;
            node.left = null;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Tree114_flatten().flatten(treeNode);
        System.out.println();
    }
}