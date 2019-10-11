import util.TreeNode;
import util.Util;

public class SerializeAndDeserializeBST449 {
    public int index = 0;

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    private void serialize(TreeNode root, StringBuilder str) {
        if (root == null) return;
        str.append((char) root.val);
        serialize(root.left, str);
        serialize(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.index = 0;
        char[] arr = data.toCharArray();
        return deserialize(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(char[] arr, int minValue, int maxValue) {
        if (index >= arr.length || (int) arr[index] > maxValue) {
            return null;
        }
        TreeNode root = new TreeNode((int) arr[index++]);
        root.left = deserialize(arr, minValue, root.val);
        root.right = deserialize(arr, root.val, maxValue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        SerializeAndDeserializeBST449 obj = new SerializeAndDeserializeBST449();
        long start = System.currentTimeMillis();
        String str = obj.serialize(treeNode);
        TreeNode result = obj.deserialize(str);

        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}