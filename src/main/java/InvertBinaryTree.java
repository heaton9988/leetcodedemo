import util.TreeNode;
import util.Util;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 2, 7, 1, 3, null, 9};

        TreeNode treeNode = Util.arr2tree(arr);
        InvertBinaryTree obj = new InvertBinaryTree();
        long start = System.currentTimeMillis();
        System.out.println(obj.invertTree(treeNode));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}