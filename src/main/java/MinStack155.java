import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack155 {
    Stack<Integer> stack = new Stack();
    PriorityQueue<Integer> q = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MinStack155() {

    }

    public void push(int x) {
        stack.push(x);
        q.add(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        q.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return q.peek();
    }

    public static void main(String[] args) {
        MinStack155 obj = new MinStack155();
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