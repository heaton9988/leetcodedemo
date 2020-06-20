import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree314_verticalOrder {
    int min = 0, max = 0;
    List<List<Integer>> res = new ArrayList<>();

    private void dfs(TreeNode node, int column) {
        if (node == null) return;
        min = Math.min(min, column);
        max = Math.max(max, column);
        dfs(node.left, column - 1);
        dfs(node.right, column + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> columns = new LinkedList<>();
        queue.offer(root);
        columns.offer(-min);
        while (!queue.isEmpty()) {
            for (int size = queue.size(), i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int column = columns.poll();
                res.get(column).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    columns.add(column - 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    columns.add(column + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new Tree314_verticalOrder().verticalOrder(Util.arr2tree(3, 9, 20, null, null, 15, 7));
        System.out.println(o);
    }
}