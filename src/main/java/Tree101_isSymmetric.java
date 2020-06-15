import util.TreeNode;
import util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Tree101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeMap<Integer, Integer> cache = new TreeMap<>();
        HashMap<Integer, TreeNode> undoMap = new HashMap<>();
        undoMap.put(0, root);
        while (!undoMap.isEmpty()) {
            Map.Entry<Integer, TreeNode> entry = undoMap.entrySet().iterator().next();
            Integer key = entry.getKey();
            TreeNode value = entry.getValue();
            cache.put(key, value.val);
            if (value.left != null) {
                undoMap.put(key * 2 + 1, value.left);
            }
            if (value.right != null) {
                undoMap.put(key * 2 + 2, value.right);
            }
            undoMap.remove(key);
        }
        int maxKey = cache.lastKey();
        Integer[] arr = new Integer[maxKey + 1];
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            arr[entry.getKey()] = entry.getValue();
        }
        for (int i = 0; ; i++) {
            int start = (int) Math.pow(2, i) - 1;
            if (start >= arr.length) break;
            int end = (int) Math.pow(2, i + 1) - 2;
            int mid = start + (end - start) / 2;
            for (int j = 0; j <= mid - start; j++) {
                Integer a = j + start >= arr.length ? null : arr[j + start];
                Integer b = end - j >= arr.length ? null : arr[end - j];
                if (!Objects.equals(a, b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
//        TreeNode treeNode = Util.arr2tree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Object o = new Tree101_isSymmetric().isSymmetric(treeNode);
        System.out.println(o);
    }
}