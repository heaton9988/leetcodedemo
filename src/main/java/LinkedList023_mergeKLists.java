import util.ListNode;
import util.Util;

public class LinkedList023_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];

        ListNode res = null;
        for (int i = 0; i < n; i++) {
            res = mergeList(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeList(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        if (n1 != null) curr.next = n1;
        if (n2 != null) curr.next = n2;
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList023_mergeKLists().mergeKLists(new ListNode[]{Util.arr2listNode(1, 4, 5), Util.arr2listNode(1, 3, 4), Util.arr2listNode(2, 6)});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}