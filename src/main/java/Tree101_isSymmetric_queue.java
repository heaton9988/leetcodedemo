import util.TreeNode;
import util.Util;

import java.util.LinkedList;
import java.util.Objects;

public class Tree101_isSymmetric_queue {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node1 = list.poll();
            TreeNode node2 = list.poll();
            Integer a1 = node1 == null ? null : node1.val;
            Integer a2 = node2 == null ? null : node2.val;
            if (!Objects.equals(a1, a2)) {
                return false;
            }
            if (a1 != null) {
                list.add(node1.left);
                list.add(node2.right);
                list.add(node1.right);
                list.add(node2.left);
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Object o = new Tree101_isSymmetric_queue().isSymmetric(treeNode);
        System.out.println(o);
    }
}