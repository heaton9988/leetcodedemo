import java.util.LinkedList;

public class Stack225_MyStack {
    LinkedList<Integer> q1;
    LinkedList<Integer> q2;
    int last;

    /**
     * Initialize your data structure here.
     */
    public Stack225_MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        last = x;
        if (!q2.isEmpty()) {
            q2.addLast(x);
        } else {
            q1.addLast(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q2.isEmpty()) {
            int size = q1.size();
            for (int i = 1; i <= size; i++) {
                if (i == size) {
                    return q1.pollFirst();
                } else {
                    q2.addLast(last = q1.pollFirst());

                }
            }
        } else {
            int size = q2.size();
            for (int i = 1; i <= size; i++) {
                if (i == size) {
                    return q2.pollFirst();
                } else {
                    q1.addLast(last = q2.pollFirst());
                }
            }
        }
        return 0;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return last;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        Stack225_MyStack obj = new Stack225_MyStack();
        long start = System.currentTimeMillis();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int a = obj.top();
        int b = obj.pop();
        int c = obj.pop();

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}