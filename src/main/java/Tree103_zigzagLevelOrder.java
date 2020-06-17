import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean direct = false;

        while (!list.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            res.add(temp);
            direct = !direct;
            for (int len = list.size(), i = 0; i < len; i++) {
                TreeNode node = list.poll();
                if (direct) {
                    temp.add(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree103_zigzagLevelOrder().zigzagLevelOrder(treeNode);
        System.out.println(o);
    }
}