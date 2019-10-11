import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
            if (list.size() > 0) {
                ret.add(list);
            }
            for (int i = nodes.size() - 1; i >= 0; i--) {
                stack.push(nodes.get(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        long start = System.currentTimeMillis();
        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal102().levelOrder(treeNode);
        System.out.println(lists);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}