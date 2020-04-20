package mine;

import util.ListNode;
import util.Util;

import java.util.HashMap;

public class Test {
    public int loopLength(ListNode head) {
        ListNode curr = head;

        int count = 0;
        HashMap<ListNode, Integer> node2index = new HashMap<>();
        while (curr != null) {
            Integer index = node2index.get(curr);
            if (index == null) {
                node2index.put(curr, count++);
                curr = curr.next;
            }  else {
                return count - index;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode listNode = Util.arr2listNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        HashMap<Integer, ListNode> value2node = new HashMap<>();
        ListNode curr = listNode;
        while (curr != null) {
            value2node.put(curr.val, curr);
            curr = curr.next;
        }

        value2node.get(7).next = value2node.get(3);

        System.out.println(new Test().loopLength(listNode));
    }
}
