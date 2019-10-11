import util.TreeNode;
import util.Util;

public class DiameterOfBinaryTree543 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return result;
    }

    private int depth(TreeNode curr) {
        if (curr == null) return 0;
        int left = depth(curr.left);
        int right = depth(curr.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        DiameterOfBinaryTree543 obj = new DiameterOfBinaryTree543();
        long start = System.currentTimeMillis();
        System.out.println(obj.diameterOfBinaryTree(node));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}