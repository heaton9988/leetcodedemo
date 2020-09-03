package toutiao;

import util.TreeNode;
import util.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    /**
     * 二叉树的前中后遍历(递归方式)
     *
     * @param node
     */
    public void recusion(TreeNode node, String mode) {
        if (node == null) return;
        if (mode.equals("preOrder")) System.out.println(node.val);
        recusion(node.left, mode);
        if (mode.equals("inOrder")) System.out.println(node.val);
        recusion(node.right, mode);
        if (mode.equals("postOrder")) System.out.println(node.val);
    }

    // 迭代preOrder , addFirst/ pollFirst, 放入队列的时候, 先放right,再放left, 从队列拿出的元素, 立即print
    public void iterationPreOrder(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.pollFirst();
            System.out.println(ele.val);
            if (ele.right != null) queue.addFirst(ele.right);
            if (ele.left != null) queue.addFirst(ele.left);
        }
    }

    // 迭代inOrder , 用栈原理实现
    public void iterationInOrder(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList();
        while (node != null || !queue.isEmpty()) {
            while (node != null) {
                queue.addLast(node);
                node = node.left;
            }
            node = queue.pollLast();
            System.out.println(node.val);
            node = node.right;
        }
    }

    // 巧妙, 中间的最后打, 所以最后输出的先调用linkedList.addFirst
    public void iterationPostOrder(TreeNode node) {
        if (node == null) return;
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode ele = stack.pop();
            if (ele.left != null) stack.push(ele.left);
            if (ele.right != null) stack.push(ele.right);
            res.addFirst(ele.val);
        }
        for (int num : res) System.out.println(num);
    }

    public void levelOrderIteration(TreeNode node) {
        if (node == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode ele = queue.pollFirst();
                System.out.println(ele.val);
                if (ele.left != null) queue.addLast(ele.left);
                if (ele.right != null) queue.addLast(ele.right);
            }
        }
    }

    public void levelOrderRecursion(TreeNode node) {
        if (node == null) return;
        ArrayList<ArrayList> res = new ArrayList<>();
        helpLevel(node, 0, res);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.println(num);
            }
        }
    }

    private void helpLevel(TreeNode node, int level, ArrayList<ArrayList> res) {
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left != null) helpLevel(node.left, level + 1, res);
        if (node.right != null) helpLevel(node.right, level + 1, res);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal obj = new BinaryTreeTraversal();
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
//        obj.recusion(treeNode, "preOrder");
//        obj.recusion(treeNode, "inOrder");
//        obj.recusion(treeNode, "postOrder");
//        obj.iterationPreOrder(treeNode);
//        obj.iterationInOrder(treeNode);
//        obj.iterationPostOrder(treeNode);
//        obj.levelOrderRecursion(treeNode);
        obj.levelOrderIteration(treeNode);
    }
}