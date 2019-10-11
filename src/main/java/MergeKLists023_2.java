import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKLists023_2 {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;

        for (ListNode node : lists) {
            while (node != null) {
                q.add(node.val);
                node = node.next;
            }
        }
        while (!q.isEmpty()) {
            last.next = new ListNode(q.poll());
            last = last.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(6);
        l1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2 = new ListNode(1);
        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(6);
        l2.next = l2_2;
        l2_2.next = l2_3;

        ListNode l3 = new ListNode(1);
        ListNode l3_2 = new ListNode(4);
        ListNode l3_3 = new ListNode(6);
        l3.next = l3_2;
        l3_2.next = l3_3;

        long start = System.currentTimeMillis();

        ListNode result = new MergeKLists023_2().mergeKLists(Arrays.asList(l1, l2, l3).toArray(new ListNode[0]));
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}