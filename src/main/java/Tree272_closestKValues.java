import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Tree272_closestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> new Double(Math.abs(1.0 * b - target)).compareTo(Math.abs(a - target)));
        dfs(root, k, pq);
        return Arrays.asList(pq.toArray(new Integer[0]));
    }

    private void dfs(TreeNode node, int k, PriorityQueue pq) {
        if (node == null) return;
        pq.add(node.val);
        if (pq.size() > k) {
            pq.poll();
        }
        dfs(node.left, k, pq);
        dfs(node.right, k, pq);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{4, 2, 5, 1, 3});
        Object o = new Tree272_closestKValues().closestKValues(treeNode, 3.71, 2);
        System.out.println(o);
    }
}