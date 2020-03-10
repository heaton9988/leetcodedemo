package zongjie1;

import util.ListNode;
import util.Util;

import java.util.TreeSet;

public class HasCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        TreeSet<ListNode> nodes = new TreeSet<>();
        while (head != null) {
            if (nodes.contains(head)) return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode param = Util.arr2listNode(new int[]{1, 2, 3, 4, 5});
        Object o = new HasCycle141().hasCycle(param);
        System.out.println(o);
    }
}
