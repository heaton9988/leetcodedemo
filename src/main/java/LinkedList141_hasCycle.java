import util.ListNode;
import util.Util;

public class LinkedList141_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || slow.next == null || fast == null || fast.next == null || fast.next.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object obj = new LinkedList141_hasCycle().hasCycle(Util.buildCycliclistNode(new Integer[]{3, 2, 0, -4}, 1, 3));
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}