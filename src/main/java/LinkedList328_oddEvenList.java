import util.ListNode;
import util.Util;

public class LinkedList328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode currOdd = head;
        ListNode evenHead = head.next;
        ListNode currEven = evenHead;
        while (currEven != null && currEven.next != null) {
            currOdd.next = currEven.next;
            currOdd = currOdd.next;
            currEven.next = currOdd.next;
            currEven = currEven.next;
        }
        currOdd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object obj = new LinkedList328_oddEvenList().oddEvenList(Util.arr2listNode(1, 2, 3, 4, 5, 6));
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}