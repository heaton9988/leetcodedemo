import util.TreeNode;
import util.Util;

public class Tree333_largestBSTSubtree {
    int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return ans;
    }

    private Integer[] helper(TreeNode node) {
        if (node == null) return new Integer[]{0, null, null};
        if (node.left == null && node.right == null) {
            if (ans < 1) ans = 1;
            return new Integer[]{1, node.val, node.val};
        }
        Integer[] resultLeft = helper(node.left);
        Integer[] resultRight = helper(node.right);

        if (resultLeft[0] == -1 || resultRight[0] == -1) {
            return new Integer[]{-1, null, null};
        }
        if (resultLeft[2] != null && node.val <= resultLeft[2]) {
            return new Integer[]{-1, null, null};
        }
        if (resultRight[1] != null && node.val >= resultRight[1]) {
            return new Integer[]{-1, null, null};
        }

        int result = 1 + resultLeft[0] + resultRight[0];
        if (result > ans) ans = result;
        return new Integer[]{result, resultLeft[1] == null ? node.val : resultLeft[1], resultRight[2] == null ? node.val : resultRight[2]};
    }

    public static void main(String[] args) {
//        Object o = new Tree333_largestBSTSubtree().largestBSTSubtree(Util.arr2tree(10, 5, 15, 1, 8, null, 7));
//        Object o = new Tree333_largestBSTSubtree().largestBSTSubtree(Util.arr2tree(3,2,4,null,null,1));
//        Object o = new Tree333_largestBSTSubtree().largestBSTSubtree(Util.arr2tree(2, 3, null, 1));
        Object o = new Tree333_largestBSTSubtree().largestBSTSubtree(Util.arr2tree(4, 2, 7, 2, 3, 5, null, 2, null, null, null, null, null, null, null, 1));
        System.out.println(o);
    }
}