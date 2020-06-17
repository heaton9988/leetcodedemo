import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tree107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            res.addFirst(temp);
            for (int len = list.size(), i = 0; i < len; i++) {
                TreeNode e = list.poll();
                temp.add(e.val);
                if (e.left != null) list.add(e.left);
                if (e.right != null) list.add(e.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Object o = new Tree107_levelOrderBottom().levelOrderBottom(treeNode);
        System.out.println(o);
    }
}