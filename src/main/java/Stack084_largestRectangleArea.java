import java.util.Stack;

public class Stack084_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int area = 0;
        int h[] = new int[len + 2];
        for (int i = 0; i < len; i++) {
            h[i + 1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < h.length; i++) {
            while (h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = i - stack.peek()-1;
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        Stack084_largestRectangleArea obj = new Stack084_largestRectangleArea();
        long start = System.currentTimeMillis();
//        Object o = obj.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        Object o = obj.largestRectangleArea(new int[]{2, 1, 2});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}