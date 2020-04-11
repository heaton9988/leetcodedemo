import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    int preIndex = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> value2index = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int count = 0;
        for (int value : inorder) {
            value2index.put(value, count++);
        }
        return helper(0, inorder.length - 1);
    }


    private TreeNode helper(int start, int end) {
        if (start > end) return null;

        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        int middle = value2index.get(rootValue);

        root.left = helper(start, middle - 1);
        root.right = helper(middle + 1, end);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
        long start = System.currentTimeMillis();
        TreeNode treeNode = obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}