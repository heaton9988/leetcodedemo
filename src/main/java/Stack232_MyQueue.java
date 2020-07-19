import java.util.Stack;

public class Stack232_MyQueue {
    Stack<Integer> left;
    Stack<Integer> right;

    public Stack232_MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        left.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        int res = right.pop();
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        int res = right.peek();
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return left.isEmpty();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Stack232_MyQueue queue = new Stack232_MyQueue();
        queue.push(1);
        queue.push(2);
        int a = queue.peek();  // 返回 1
        int b = queue.pop();   // 返回 1
        boolean c = queue.empty(); // 返回 false

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}