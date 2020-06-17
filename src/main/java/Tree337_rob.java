import util.TreeNode;
import util.Util;

import java.util.*;

public class Tree337_rob {
    HashMap<TreeNode, Integer> falseMap = new HashMap<>();
    HashMap<TreeNode, Integer> trueMap = new HashMap<>();

    public int rob(TreeNode root) {
        return Math.max(helper(root, true), helper(root, false));
    }

    private int helper(TreeNode node, boolean rob) {
        if (node == null) return 0;
        if (rob) {
            if (trueMap.containsKey(node)) return trueMap.get(node);
        } else {
            if (falseMap.containsKey(node)) return falseMap.get(node);
        }
        int result = 0;
        if (node.left == null && node.right == null) {
            result = rob ? node.val : 0;
        } else if (rob) {
            result = node.val + helper(node.left, false) + helper(node.right, false);
        } else {
            int leftFalse = helper(node.left, false);
            int leftTrue = helper(node.left, true);
            int rightFalse = helper(node.right, false);
            int rightTrue = helper(node.right, true);
            result = (leftFalse > leftTrue ? leftFalse : leftTrue) + (rightFalse > rightTrue ? rightFalse : rightTrue);
        }
        if (rob) {
            trueMap.put(node, result);
        } else {
            falseMap.put(node, result);
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 2, 3, null, 3, null, 1});
        Object o = new Tree337_rob().rob(treeNode);
        System.out.println(o);
    }
}