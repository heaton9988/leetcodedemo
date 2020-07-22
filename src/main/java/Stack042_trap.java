import java.util.Stack;

public class Stack042_trap {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) break;
                int leftIndex = stack.peek();
                int left = height[leftIndex];
                int width = i - leftIndex - 1;
                int h = Math.min(left, height[i]) - bottom;
                int temp = width * h;
                res += temp > 0 ? temp : 0;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack042_trap obj = new Stack042_trap();
        long start = System.currentTimeMillis();
//        Object o = obj.trap(new int[]{ 2, 1, 0, 2});
        Object o = obj.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}