import java.util.Stack;

public class Stack155_MinStack {
    Stack<Integer> normal;
    Stack<Integer> min;

    public Stack155_MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        Integer top = normal.pop();
        if (min.peek().equals(top)) {
            min.pop();
        }
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        Stack155_MinStack obj = new Stack155_MinStack();
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