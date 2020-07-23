public class Stack581_findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] stack = new int[len];
        int size = 0;
        Integer left = null, right = null;
        for (int i = 0; i < len; i++) {
            while (size > 0 && nums[i] < nums[stack[size - 1]]) {
                if (left == null || left > size - 1) {
                    left = size - 1;
                }
                size--;
                right = i;
            }
            stack[size++] = i;
        }
        size = 0;
        for (int i = len - 1; i >= 0; i--) {
            while (size > 0 && nums[i] > nums[stack[size - 1]]) {
                if (stack[size - 1] > right) right = stack[size - 1];
                if (i < left) left = i;
                size--;
            }
            stack[size++] = i;
        }
        return left == null ? 0 : right - left + 1;
    }

    public static void main(String[] args) throws Exception {
        Stack581_findUnsortedSubarray obj = new Stack581_findUnsortedSubarray();
        long start = System.currentTimeMillis();
//        Object o = obj.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
//        Object o = obj.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2});
        Object o = obj.findUnsortedSubarray(new int[]{2, 3, 3, 2, 4});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}