import util.TreeNode;
import util.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Tree272_closestKValues_2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }
    public void helper(LinkedList<Integer> res, TreeNode root, double target, int k){
        if (root == null) return;
        helper(res, root.left, target, k);
        if (res.size() == k){
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())){
                res.removeFirst();
            } else return;
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{4, 2, 5, 1, 3});
        Object o = new Tree272_closestKValues_2().closestKValues(treeNode, 3.71, 2);
        System.out.println(o);
    }
}