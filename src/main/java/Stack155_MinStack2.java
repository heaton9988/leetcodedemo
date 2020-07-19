public class Stack155_MinStack2 {
    static class Node {
        int val;
        int min;
        Node next;
    }

    Node head;

    public Stack155_MinStack2() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node();
            head.val = x;
            head.min = x;
        } else {
            Node n = new Node();
            n.val = x;
            n.min = Math.min(x, head.min);
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
        Stack155_MinStack2 obj = new Stack155_MinStack2();
        long start = System.currentTimeMillis();
        obj.push(1);
        obj.push(11);
        obj.push(3);
        obj.push(2);
        obj.push(8);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}