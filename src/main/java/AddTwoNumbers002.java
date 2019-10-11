public class AddTwoNumbers002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addTwoNumbers(l1, l2, 0, null);
        return l1;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, int toAdd, ListNode lastL1) {
        if (l1 == null && l2 == null && toAdd == 0) return;
        if (l1 == null) {
            l1 = new ListNode(0);
            lastL1.next = l1;
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int currSum = toAdd + l1.val + l2.val;
        l1.val = currSum % 10;

        addTwoNumbers(l1.next, l2.next, currSum / 10, l1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

        long start = System.currentTimeMillis();
        ListNode l1 = new ListNode(5);
//        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(3);
//        l1.next = l1_2;
//        l1_2.next = l1_3;
        ListNode l2 = new ListNode(5);
//        ListNode l2_2 = new ListNode(6);
//        ListNode l2_3 = new ListNode(4);
//        ListNode l2_4 = new ListNode(1);
//        l2.next = l2_2;
//        l2_2.next = l2_3;
//        l2_3.next = l2_4;

        ListNode result = new AddTwoNumbers002().addTwoNumbers(l1, l2);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}