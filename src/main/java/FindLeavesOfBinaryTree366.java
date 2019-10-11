import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree366 {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return ret;
        while (true) {
            List<Integer> list = new ArrayList<>();
            int rootIsLeaf = ifLeaf(root);
            if (rootIsLeaf == 1) {
                list.add(root.val);
                root = null;
            } else if (rootIsLeaf == 0) {
                removeLeaves(root, list);
            } else if (rootIsLeaf == -1) {
                break;
            }
            if (list.size() > 0) {
                ret.add(list);
            } else {
                break;
            }
        }
        return ret;
    }

    private void removeLeaves(TreeNode node, List<Integer> list) {
        int leftIsLeaf = ifLeaf(node.left);
        if (leftIsLeaf == 1) {
            list.add(node.left.val);
            node.left = null;
        } else if (leftIsLeaf == 0) {
            removeLeaves(node.left, list);
        }
        int rightIsLeaf = ifLeaf(node.right);
        if (rightIsLeaf == 1) {
            list.add(node.right.val);
            node.right = null;
        } else if (rightIsLeaf == 0) {
            removeLeaves(node.right, list);
        }
    }

    private int ifLeaf(TreeNode curr) {
        if (curr == null) return -1;
        if (curr.left == null && curr.right == null) return 1;
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        FindLeavesOfBinaryTree366 obj = new FindLeavesOfBinaryTree366();
        long start = System.currentTimeMillis();
        System.out.println(obj.findLeaves(node));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}