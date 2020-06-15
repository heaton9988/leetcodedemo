import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode node, int sum, List<Integer> list, List<List<Integer>> res) {
        if (node == null) return;
        sum -= node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
        } else {
            helper(node.left, sum, list, res);
            helper(node.right, sum, list, res);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1,2,3});
        Object o = new Tree113_pathSum().pathSum(treeNode, 22);
        System.out.println(o);
    }
}