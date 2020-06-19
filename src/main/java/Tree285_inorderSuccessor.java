import util.TreeNode;
import util.Util;

import java.util.Map;
import java.util.TreeMap;

public class Tree285_inorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode target = root;
        TreeMap<Integer, TreeNode> value2node = new TreeMap<>();
        while (target != null) {
            if (p.val == target.val) {
                break;
            }
            value2node.put(target.val, target);
            if (p.val > target.val) {
                target = target.right;
            } else {
                target = target.left;
            }
        }
        if (target.right != null) {
            target = target.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        } else {
            for (Map.Entry<Integer, TreeNode> entry : value2node.entrySet()) {
                if (p.val < entry.getKey()) return entry.getValue();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        for (int i = 1; i < 7; i++) {
            TreeNode o = new Tree285_inorderSuccessor().inorderSuccessor(treeNode, new TreeNode(i));
            System.out.println(o == null ? "null" : o.val);
        }
    }
}