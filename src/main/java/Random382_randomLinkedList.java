import util.ListNode;

import java.util.Random;

public class Random382_randomLinkedList {
    ListNode head;
    Random r = new Random();

    public Random382_randomLinkedList(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode curr = head;
        int count = 0;
        int res = head.val;
        while (curr != null) {
            if (r.nextInt() % ++count == 0) {
                res = curr.val;
            }
            curr = curr.next;
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 初始化一个单链表 [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Random382_randomLinkedList solution = new Random382_randomLinkedList(head);

        for (int i = 0; i < 10; i++) {
            // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
            System.out.println(solution.getRandom());
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}