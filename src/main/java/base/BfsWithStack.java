package base;

import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BfsWithStack {
    public static void bfs(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (true) {
            List<TreeNode> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if (pop.left != null) {
                    list.add(pop.left);
                }
                if (pop.right != null) {
                    list.add(pop.right);
                }
            }
            if (list.size() > 0) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        bfs(treeNode);
        System.out.println(treeNode);
    }
}