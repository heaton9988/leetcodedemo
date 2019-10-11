package util;


public class Util {
    public static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int a : arr) {
            sb.append(a).append(", ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
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
}