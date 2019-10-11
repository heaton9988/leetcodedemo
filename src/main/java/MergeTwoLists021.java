public class MergeTwoLists021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
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

        ListNode result = new MergeTwoLists021().mergeTwoLists(l1, l2);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}