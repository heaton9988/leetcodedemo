import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Tree095_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n, 0);
    }

    private List<TreeNode> helper(int start, int end, int level) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        } else {
            for (int mid = start; mid <= end; mid++) {
                List<TreeNode> leftNodes = helper(start, mid - 1, level + 1);
                List<TreeNode> rightNodes = helper(mid + 1, end, level + 1);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode node = new TreeNode(mid);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new Tree095_generateTrees().generateTrees(3);
        System.out.println(o);
    }
}