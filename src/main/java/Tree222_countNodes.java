import util.TreeNode;
import util.Util;

import java.util.ArrayList;

public class Tree222_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxIndex(root.left, 1), maxIndex(root.right, 2)) + 1;
    }

    private int maxIndex(TreeNode node, int nodeIndex) {
        if (node == null) return 0;
        return Math.max(nodeIndex, Math.max(maxIndex(node.left, nodeIndex * 2 + 1), maxIndex(node.right, nodeIndex * 2 + 2)));
    }

    public static void main(String[] args) {
        Object o = new Tree222_countNodes().countNodes(Util.arr2tree(1, 2, 3, 4, 5, 6, 7));
        System.out.println(o);
    }
}