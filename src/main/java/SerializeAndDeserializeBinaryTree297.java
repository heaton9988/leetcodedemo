import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        pserialize(root, sb);
        return sb.toString();
    }

    public void pserialize(TreeNode curr, StringBuilder sb) {
        sb.append(curr == null ? null : curr.val).append(",");
        if (curr == null) return;
        pserialize(curr.left, sb);
        pserialize(curr.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().equals("")) return null;
        String[] numbers = data.split(",");
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        LinkedList<String> numberList = new LinkedList<>(Arrays.asList(numbers));

        TreeNode root = new TreeNode(Integer.parseInt(numberList.remove(0)));

        pdeserialize(root, numberList);
        return root;
    }

    private void pdeserialize(TreeNode curr, LinkedList<String> numberList) {
        String strLeft = numberList.remove(0);
        if (!strLeft.equals("null")) {
            curr.left = new TreeNode(Integer.parseInt(strLeft));
            pdeserialize(curr.left, numberList);
        }

        String strRight = numberList.remove(0);
        if (!strRight.equals("null")) {
            curr.right = new TreeNode(Integer.parseInt(strRight));
            pdeserialize(curr.right, numberList);
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree297 obj = new SerializeAndDeserializeBinaryTree297();
//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] arr = new Integer[]{1, 2, 5, 3, 4, null, null};

        TreeNode treeNode = arr2tree(arr);

        long start = System.currentTimeMillis();
        String serialize = obj.serialize(treeNode);
        TreeNode deserialize = obj.deserialize(serialize);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public static TreeNode arr2tree(Integer[] arr) {
        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            nodeArr[i] = new TreeNode(arr[i]);
            if (i != 0) {
                if (i % 2 == 0) {
                    nodeArr[(i - 1) / 2].right = nodeArr[i];
                } else {
                    nodeArr[(i - 1) / 2].left = nodeArr[i];
                }
            }
        }
        return nodeArr[0];
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}