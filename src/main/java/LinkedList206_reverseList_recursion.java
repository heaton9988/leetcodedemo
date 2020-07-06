import util.ListNode;
import util.Util;

public class LinkedList206_reverseList_recursion {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode curr, ListNode pre) {
        if (curr == null) return null;
        ListNode temp = curr.next;
        curr.next = pre;
        ListNode res = helper(temp, curr);
        return res == null ? curr : res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object obj = new LinkedList206_reverseList_recursion().reverseList(Util.arr2listNode(new Integer[]{1, 2, 3}));
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}