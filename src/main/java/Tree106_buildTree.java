import util.TreeNode;

import java.util.HashMap;

public class Tree106_buildTree {
    int postIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int nodeVal = postorder[postorder.length - 1 - postIndex++];
        TreeNode node = new TreeNode(nodeVal);
        int mid = map.get(nodeVal);
        node.right = helper(postorder, inorder, mid + 1, inEnd);
        node.left = helper(postorder, inorder, inStart, mid - 1);
        return node;
    }

    public static void main(String[] args) {
        Object o = new Tree106_buildTree().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(o);
    }
}