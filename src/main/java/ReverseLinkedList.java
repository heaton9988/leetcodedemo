import util.ListNode;
import util.Util;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode curr) {
        ListNode last = null;
        while (curr != null) {
            ListNode copyCurr = new ListNode(curr.val);
            copyCurr.next = last;
            last = copyCurr;
            curr = curr.next;
        }
        return last;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 2, 7, 1, 3, 9};

        ListNode node = Util.arr2listNode(arr);
        ReverseLinkedList obj = new ReverseLinkedList();
        long start = System.currentTimeMillis();
        System.out.println(obj.reverseList(node));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}