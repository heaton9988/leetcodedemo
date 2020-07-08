import util.ListNode;
import util.Util;

public class LinkedList160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        ListNode listNode = new LinkedList160_getIntersectionNode().getIntersectionNode(Util.arr2listNode(2, 4, 3), Util.arr2listNode(5, 6, 7));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}