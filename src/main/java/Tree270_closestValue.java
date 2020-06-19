import util.TreeNode;
import util.Util;

public class Tree270_closestValue {
    double diff = Double.MAX_VALUE;
    int result;

    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        result = root.val;
        while (cur != null) {
            if (target == cur.val) return cur.val;

            double currDiff = Math.abs(1.0 * target - cur.val);
            if (currDiff < diff) {
                diff = currDiff;
                result = cur.val;
            }

            if (target > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = Util.arr2tree(new Integer[]{4, 2, 5, 1, 3});
        TreeNode treeNode = Util.arr2tree(new Integer[]{1500000000, 1400000000});
        Object o = new Tree270_closestValue().closestValue(treeNode, -1500000000);
        System.out.println(o);
    }
}