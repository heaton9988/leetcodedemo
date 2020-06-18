import util.TreeNode;
import util.Util;

public class Tree297_Codec_2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        ps(root, sb);
        return sb.toString();
    }

    private void ps(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        ps(node.left, sb);
        ps(node.right, sb);
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return pdes(data);
    }

    private TreeNode pdes(String data) {
        char c = data.charAt(index);
        if (c == '#') {
            index += 2; // 跳过 "#," 这两个字符
            return null;
        }
        boolean minus = false;
        int sum = 0;
        while ((c = data.charAt(index++)) != ',') {
            if (c == '-') {
                minus = true;
            } else {
                sum = sum * 10 + (c - '0');
            }
        }
        if (minus) sum = -sum;

        TreeNode node = new TreeNode(sum);
        node.left = pdes(data);
        node.right = pdes(data);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = Util.arr2tree(new Integer[]{3, 1, 4, null, 2});
        Tree297_Codec_2 obj = new Tree297_Codec_2();
        String str = obj.serialize(node);
        TreeNode deserialize = obj.deserialize(str);
        System.out.println(str);
        System.out.println();
    }
}