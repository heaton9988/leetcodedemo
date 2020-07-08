import util.ListNode;
import util.Util;

public class LinkedList234_isPalindrome_recursion {
    private ListNode head;

    private boolean check(ListNode curr) {
        if (curr != null) {
            if (!check(curr.next)) {
                return false;
            }
            if (curr.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        this.head = head;
        return check(head);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new LinkedList234_isPalindrome_recursion().isPalindrome(Util.arr2listNode(1, 2, 3, 2, 1));
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}