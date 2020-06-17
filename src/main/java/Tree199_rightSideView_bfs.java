import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree199_rightSideView_bfs {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);

            while (!list.isEmpty()) {
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = list.poll();
                    if (node.left != null) list.add(node.left);
                    if (node.right != null) list.add(node.right);
                    if (i == len - 1) res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, null, 5, null, 4});
        Object o = new Tree199_rightSideView_bfs().rightSideView(treeNode);
        System.out.println(o);
    }
}