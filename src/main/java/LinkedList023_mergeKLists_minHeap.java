import util.ListNode;
import util.Util;

import java.util.PriorityQueue;

public class LinkedList023_mergeKLists_minHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(n, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList023_mergeKLists_minHeap().mergeKLists(new ListNode[]{Util.arr2listNode(1, 4, 5), Util.arr2listNode(1, 3, 4), Util.arr2listNode(2, 6)});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}