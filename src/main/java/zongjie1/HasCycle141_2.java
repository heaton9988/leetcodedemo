package zongjie1;

import util.ListNode;
import util.Util;

import java.util.TreeSet;

public class HasCycle141_2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (head != null && head.next != null) {
            slow = head.next;
            fast = head.next.next;
            if (fast == null || slow == null) return false;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode param = Util.arr2listNode(new int[]{1, 2, 3, 4, 5});
        Object o = new HasCycle141_2().hasCycle(param);
        System.out.println(o);
    }
}
