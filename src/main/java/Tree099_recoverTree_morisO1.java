import util.TreeNode;
import util.Util;

/**
 * 没有看懂, 但是据说可以用O(1)的空间复杂度, 优于原先用迭代方式的O(n)
 */
public class Tree099_recoverTree_morisO1 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        TreeNode tmp = null;
        while (root != null) {
            if (root.left != null) {
                tmp = root.left;
                while (tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    if (pre != null && pre.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            } else {
                if (pre != null && pre.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{2, 3, 1});
        new Tree099_recoverTree_morisO1().recoverTree(treeNode);
        System.out.println();
    }
}