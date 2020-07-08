import util.ListNode;
import util.Util;

public class LinkedList148_sortList_bottom2top {
    public ListNode sortList(ListNode head) { // 归并排序
        int n = 0;
        // 走到null，刚好走链表的长度
        for (ListNode i = head; i != null; i = i.next) {
            n++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 循环一下
        // 第一层循环，分块，从1个一块，2个一块，4个一块，直到n个一块，
        for (int blockSize = 1; blockSize < n; blockSize = 2 * blockSize) { // block可能包含多个元素, 这些元素都是在上次循环中排序好的, 所以第一次循环, block从1个开始
            ListNode begin = dummy;
            // 开始归并
            // j + i < n 表示只有一段就不归并了，因为已经是排好序的
            for (int j = 0; j + blockSize < n; j = j + 2 * blockSize) {
                // 两块，找两块的起始节点
                // 开始都指向第一块的起点
                // 然后second走n步指向第二块的起点
                ListNode first = begin.next, second = first;
                for (int k = 0; k < blockSize; k++) second = second.next;

                // 遍历第一块和第二块进行归并 | 第一块的数量为i | 第二块的数量为i也可能小于i，所以循环条件要加一个second != null
                int f = 0, s = 0;
                while (f < blockSize && s < blockSize && second != null) {
                    if (first.val < second.val) {
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        f++;
                    } else {
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                // 归并之后可能又多余的没有处理
                while (f < blockSize) {
                    begin.next = first;
                    begin = begin.next;
                    first = first.next;
                    f++;
                }
                while (s < blockSize && second != null) {
                    begin.next = second;
                    begin = begin.next;
                    second = second.next;// second已经更新到下一块的起点了
                    s++;
                }
                begin.next = second; // 更新begin begin.next 指向下一块的起点
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList148_sortList_bottom2top().sortList(Util.arr2listNode(3, 2, 1));
        System.out.println(listNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}