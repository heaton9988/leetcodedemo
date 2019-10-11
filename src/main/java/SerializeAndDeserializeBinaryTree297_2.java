import util.TreeNode;
import util.Util;


public class SerializeAndDeserializeBinaryTree297_2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return null;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }


    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree297_2 obj = new SerializeAndDeserializeBinaryTree297_2();
//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] arr = new Integer[]{1, 2, 5, 3, 4, null, null};

        long start = System.currentTimeMillis();
        String serialize = obj.serialize(Util.arr2tree(arr));
        TreeNode deserialize = obj.deserialize(serialize);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}