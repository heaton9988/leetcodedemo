import util.ListNode;
import util.TreeNode;
import util.Util;

public class Tree109_sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null, null, null, null);
    }

    private TreeNode helper(ListNode left1, ListNode left2, ListNode mid, ListNode right1, ListNode right2) {
        if (mid == null) {
            ListNode slow = left1;
            ListNode fast = left1;
            ListNode pre = null;

            while (fast.next != null && fast.next.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast.next != null) {
                fast = fast.next;
            }
            return helper(left1, pre, slow, slow.next, fast);
        } else {
            TreeNode midNode = new TreeNode(mid.val);
            if (left1 != mid) {
                left2.next = null;
                midNode.left = helper(left1, null, null, null, null);
            }
            if (right1 != null) {
                midNode.right = helper(right1, null, null, null, null);
            }
            return midNode;
        }
    }

    public static void main(String[] args) {
        Object o = new Tree109_sortedListToBST().sortedListToBST(Util.arr2listNode(-10, -3, 0, 5, 9));
        System.out.println(o);
    }
}