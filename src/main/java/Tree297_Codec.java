import util.TreeNode;
import util.Util;

import java.util.Map;
import java.util.TreeMap;

public class Tree297_Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);
        StringBuilder sb = new StringBuilder();
        sb.append(map.size() == 0 ? 0 : 1 + map.lastKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sb.append(",").append(entry.getKey()).append(":").append(entry.getValue());
        }
        return sb.toString();
    }

    private void dfs(TreeNode node, int index, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(index, node.val);
        dfs(node.left, 2 * index + 1, map);
        dfs(node.right, 2 * index + 2, map);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        int size = Integer.parseInt(ss[0]);
        if (size == 0) return null;
        Integer[] arr = new Integer[size];
        for (int i = 1; i < ss.length; i++) {
            String[] kv = ss[i].split(":");
            arr[Integer.parseInt(kv[0])] = Integer.parseInt(kv[1]);
        }
        return helpDeserial(0, arr);
    }

    private TreeNode helpDeserial(int index, Integer[] arr) {
        if (index < 0 || index >= arr.length || arr[index] == null) return null;
        TreeNode res = new TreeNode(arr[index]);
        res.left = helpDeserial(2 * index + 1, arr);
        res.right = helpDeserial(2 * index + 2, arr);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = Util.arr2tree(new Integer[]{3, 1, 4, null, 2});
        Tree297_Codec obj = new Tree297_Codec();
        String str = obj.serialize(node);
        TreeNode deserialize = obj.deserialize(str);
        System.out.println(str);
        System.out.println();
    }
}