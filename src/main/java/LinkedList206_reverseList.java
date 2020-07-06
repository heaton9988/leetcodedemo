import util.ListNode;
import util.Util;

public class LinkedList206_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object obj = new LinkedList206_reverseList().reverseList(Util.arr2listNode(new Integer[]{1, 2, 3}));
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}