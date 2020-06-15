import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Tree257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(root, res, sb);
        return res;
    }

    private void helper(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append("->");
        int sbLen = sb.toString().length();
        if (node.left == null && node.right == null) {
            sb.setLength(sb.length() - 2);
            res.add(sb.toString());
            sb.setLength(sbLen);
            return;
        }
        helper(node.left, res, sb);
        sb.setLength(sbLen);
        helper(node.right, res, sb);
        sb.setLength(sbLen);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Object o = new Tree257_binaryTreePaths().binaryTreePaths(treeNode);
        System.out.println(o);
    }
}