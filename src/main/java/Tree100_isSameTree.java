import util.TreeNode;
import util.Util;

import java.util.Objects;

public class Tree100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        Integer val1 = p == null ? null : p.val;
        Integer val2 = q == null ? null : q.val;
        if (!Objects.equals(val1, val2)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree100_isSameTree().isSameTree(treeNode, treeNode);
        System.out.println(o);
    }
}