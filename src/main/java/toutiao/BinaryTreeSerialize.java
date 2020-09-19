package toutiao;

import util.TreeNode;
import util.Util;

public class BinaryTreeSerialize {
    public String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        pSerialize(node, sb);
        return sb.toString();
    }

    private void pSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        } else {
            sb.append(node.val).append(",");
            pSerialize(node.left, sb);
            pSerialize(node.right, sb);
        }
    }

    int index = 0;

    public TreeNode deSerialize(String s) {
        index = 0;
        return pDeSerialize(s);
    }

    private TreeNode pDeSerialize(String s) {
        if (s.charAt(index) == '#') {
            index += 2;
            return null;
        }

        int sum = 0;
        while (s.charAt(index) != ',') {
            int digit = s.charAt(index) - '0';
            sum = sum * 10 + digit;
            index++;
        }
        index++;
        TreeNode res = new TreeNode(sum);
        res.left = pDeSerialize(s);
        res.right = pDeSerialize(s);
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeSerialize obj = new BinaryTreeSerialize();
        TreeNode node = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        String str = obj.serialize(node);
        System.out.println(str);
        TreeNode de = obj.deSerialize(str);
        System.out.println(de);
    }
}