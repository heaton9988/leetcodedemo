import util.TreeNode;
import util.Util;

public class InorderSuccessorInBST285 {
    Integer targetValue = null;
    TreeNode nextValue = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        travelTree(root, p);
        return nextValue;
    }

    private void travelTree(TreeNode node, TreeNode p) {
        if (node == null || nextValue != null) return;
        travelTree(node.left, p);
        if (targetValue != null) {
            if (nextValue == null) {
                nextValue = node;
            }
            return;
        }
        if (p.val == node.val) {
            targetValue = p.val;
        }
        travelTree(node.right, p);
    }


    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        long start = System.currentTimeMillis();
        TreeNode result = new InorderSuccessorInBST285().inorderSuccessor(treeNode, new TreeNode(1));
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}