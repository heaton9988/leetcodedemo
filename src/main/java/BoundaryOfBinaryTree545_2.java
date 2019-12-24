import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree545_2 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        ret.add(root.val); // if root is not null , immediately add it into ret

        List<Integer> nodesOnLeft = new ArrayList<>();
        searchLeftTree(root.left, nodesOnLeft); // exclude root and root's right subtree

        List<Integer> nodesIsLeaf = new ArrayList<>();
        searchLeafNodes(root, nodesIsLeaf, 1); // level is used to exclude root node

        List<Integer> nodesOnRight = new ArrayList<>(); // 要反转加入结果
        searchRightTree(root.right, nodesOnRight); // exclude root and root's left subtree

        ret.addAll(nodesOnLeft);
        ret.addAll(nodesIsLeaf);
        if (nodesOnRight.size() > 0) {
            for (int i = nodesOnRight.size() - 1; i >= 0; i--) {
                ret.add(nodesOnRight.get(i));
            }
        }
        return ret;
    }

    private void searchLeftTree(TreeNode curr, List<Integer> nodesOnLeft) {
        if (curr == null) return;

        // leaf node can't be added in this method ( curr.left == null && curr.right == null )
        if (curr.left != null) {
            nodesOnLeft.add(curr.val);
            searchLeftTree(curr.left, nodesOnLeft);
        } else if (curr.right != null) {
            nodesOnLeft.add(curr.val);
            searchLeftTree(curr.right, nodesOnLeft);
        }
    }

    private void searchRightTree(TreeNode curr, List<Integer> nodesOnRight) {
        if (curr == null) return;

        // leaf node can't be added in this method ( curr.left == null && curr.right == null )
        if (curr.right != null) {
            nodesOnRight.add(curr.val);
            searchRightTree(curr.right, nodesOnRight);
        } else if (curr.left != null) {
            nodesOnRight.add(curr.val);
            searchRightTree(curr.left, nodesOnRight);
        }
    }

    private void searchLeafNodes(TreeNode curr, List<Integer> nodesIsLeaf, int level) {
        if (curr == null) return;
        if (curr.left != null) {
            searchLeafNodes(curr.left, nodesIsLeaf, 1 + level);
        } else if (curr.left == null && curr.right == null) {
            if (level != 1) nodesIsLeaf.add(curr.val);
        }
        if (curr.right != null) {
            searchLeafNodes(curr.right, nodesIsLeaf, 1 + level);
        }
    }

    public static void main(String[] args) {
        BoundaryOfBinaryTree545_2 obj = new BoundaryOfBinaryTree545_2();
        long start = System.currentTimeMillis();
//        System.out.println(obj.boundaryOfBinaryTree(Util.arr2tree(new Integer[]{1, null, 2, null, null, 3, 4})));
        System.out.println(obj.boundaryOfBinaryTree(Util.arr2tree(new Integer[]{1, null, 2, null, null, 3, 4})));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}