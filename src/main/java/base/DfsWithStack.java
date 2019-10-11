package base;

import util.TreeNode;
import util.Util;

import java.util.Stack;

public class DfsWithStack {
    public static void dfs(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        dfs(treeNode);
        System.out.println(treeNode);
    }
}