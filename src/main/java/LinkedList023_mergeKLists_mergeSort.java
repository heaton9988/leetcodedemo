import util.ListNode;
import util.Util;

public class LinkedList023_mergeKLists_mergeSort {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        return mergeKLists(lists, 0, n - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (right - left) / 2 + left;

        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList023_mergeKLists_mergeSort().mergeKLists(new ListNode[]{Util.arr2listNode(1, 4, 5), Util.arr2listNode(1, 3, 4), Util.arr2listNode(2, 6)});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}