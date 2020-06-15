import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            res.add(list);

            for (int i = 0, len = linkedList.size(); i < len; i++) {
                TreeNode node = linkedList.pollFirst();
                list.add(node.val);
                if (node.left != null) linkedList.addLast(node.left);
                if (node.right != null) linkedList.addLast(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree102_levelOrder().levelOrder(treeNode);
        System.out.println(o);
    }
}