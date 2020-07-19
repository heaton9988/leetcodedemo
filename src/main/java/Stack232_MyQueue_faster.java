import java.util.Stack;

public class Stack232_MyQueue_faster {
    Stack<Integer> left;
    Stack<Integer> right;
    int front = 0;

    public Stack232_MyQueue_faster() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!right.isEmpty()) {
            left.push(right.pop());
        }
        if (left.isEmpty()) {
            front = x;
        }
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
        if (!right.isEmpty()) {
            front = right.peek();
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Stack232_MyQueue_faster queue = new Stack232_MyQueue_faster();
        queue.push(1);
        queue.push(2);
        int a = queue.peek();  // 返回 1
        int b = queue.pop();   // 返回 1
        boolean c = queue.empty(); // 返回 false

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}