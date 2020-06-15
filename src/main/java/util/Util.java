package util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Util {
    public static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int a : arr) {
            sb.append(a).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printArr(boolean[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (boolean a : arr) {
            sb.append(a).append(",\t");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printArr(int[][] input) {
        for (int[] i : input) {
            Util.printArr(i);
        }
    }

    public static void printArr(boolean[][] input) {
        for (boolean[] i : input) {
            Util.printArr(i);
        }
    }

    public static TreeNode arr2tree(Integer[] arr) {
        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
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

    public static ListNode arr2listNode(Integer[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode n = new ListNode(arr[i]);
            curr.next = n;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode arr2listNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode n = new ListNode(arr[i]);
            curr.next = n;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static int[][] str2matrix(String str2dgrid) {
        String[] ss = str2dgrid.split(",");
        int[][] grid = new int[ss.length][];

        for (int i = 0; i < ss.length; i++) {
            int[] temp = new int[ss[i].length()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = ss[i].charAt(j) - '0';
            }
            grid[i] = temp;
        }
        return grid;
    }

    public static void printListNode(Object o) {
        ListNode node = (ListNode) o;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println("[" + sb.toString() + "]");
    }

    public static TreeMap<Integer, Integer> tree2map(TreeNode node) {
        TreeMap<Integer, Integer> cache = new TreeMap<>();
        if (node == null) return cache;

        HashMap<Integer, TreeNode> undoMap = new HashMap<>();
        undoMap.put(0, node);
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
        return cache;
    }

    public static Integer[] tree2arr(TreeNode node) {
        TreeMap<Integer, Integer> cache = tree2map(node);
        int maxKey = cache.lastKey();
        Integer[] res = new Integer[maxKey + 1];
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            res[entry.getKey()] = entry.getValue();
        }
        return res;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}