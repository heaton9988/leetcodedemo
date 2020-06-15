import util.TreeNode;
import util.Util;

public class Tree226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Object o = new Tree226_invertTree().invertTree(treeNode);
        System.out.println(o);
    }
}