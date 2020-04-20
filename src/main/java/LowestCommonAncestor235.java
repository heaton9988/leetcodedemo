import util.TreeNode;
import util.Util;

public class LowestCommonAncestor235 {
    TreeNode p;
    TreeNode q;
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        helper(root);
        return result;
    }

    private int helper(TreeNode curr) {
        if (curr == null || result != null) return 0;

        int count = 0;
        if (curr.val == p.val || curr.val == q.val) count++;

        if (p.val < curr.val || q.val < curr.val) {
            count += helper(curr.left);
        }
        if (p.val > curr.val || q.val > curr.val) {
            count += helper(curr.right);
        }

        if (count >= 2) {
            result = curr;
        }

        return count == 0 ? 0 : 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        LowestCommonAncestor235 obj = new LowestCommonAncestor235();
        long start = System.currentTimeMillis();
        TreeNode result = obj.lowestCommonAncestor(treeNode, new TreeNode(4), new TreeNode(9));
        System.out.println(result.val);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}