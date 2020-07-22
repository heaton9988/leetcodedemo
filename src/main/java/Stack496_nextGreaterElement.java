import java.util.HashMap;
import java.util.Stack;

public class Stack496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            int val = -1;
            if (!stack.isEmpty()) {
                val = stack.peek();
            }
            map.put(nums2[i], val);
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack496_nextGreaterElement obj = new Stack496_nextGreaterElement();
        long start = System.currentTimeMillis();
        Object o = obj.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}