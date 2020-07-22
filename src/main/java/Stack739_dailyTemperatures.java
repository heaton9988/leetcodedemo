import java.util.Stack;

public class Stack739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack739_dailyTemperatures obj = new Stack739_dailyTemperatures();
        long start = System.currentTimeMillis();
        Object o = obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}