package base;

import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BfsWithLinkedList {
    public static void bfs(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            TreeNode firstEle = linkedList.remove(0);
            System.out.println(firstEle.val);
            if (firstEle.left != null) {
                linkedList.add(firstEle.left);
            }
            if (firstEle.right != null) {
                linkedList.add(firstEle.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        bfs(treeNode);
        System.out.println(treeNode);
    }
}