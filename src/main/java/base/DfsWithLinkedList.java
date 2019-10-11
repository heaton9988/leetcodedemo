package base;

import util.TreeNode;
import util.Util;

import java.util.LinkedList;

public class DfsWithLinkedList {
    public static void bfs(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            TreeNode firstEle = linkedList.remove(0);
            System.out.println(firstEle.val);
            if (firstEle.right != null) {
                linkedList.addFirst(firstEle.right);
            }
            if (firstEle.left != null) {
                linkedList.addFirst(firstEle.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        bfs(treeNode);
        System.out.println(treeNode);
    }
}