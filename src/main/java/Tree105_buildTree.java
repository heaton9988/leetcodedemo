import util.TreeNode;
import util.Util;

import java.util.HashMap;

public class Tree105_buildTree {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int nodeVal = preorder[preIndex++];
        TreeNode node = new TreeNode(nodeVal);
        int mid = map.get(nodeVal);
        node.left = helper(preorder, inorder, inStart, mid - 1);
        node.right = helper(preorder, inorder, mid + 1, inEnd);
        return node;
    }

    public static void main(String[] args) {
        Object o = new Tree105_buildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(o);
    }
}