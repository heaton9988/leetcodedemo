public class Tree255_verifyPreorder_stack {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        int[] stack = new int[len];
        int top = -1;
        int min = Integer.MIN_VALUE;

        for (int value : preorder) {
            if (value < min) {
                return false;
            }

            while (top > -1 && value > stack[top]) {
                min = stack[top];
                top--;
            }

            stack[++top] = value;
        }

        return true;
    }


    public static void main(String[] args) {
        boolean b = new Tree255_verifyPreorder_stack().verifyPreorder(new int[]{5, 2, 1, 3, 6});
//        boolean b = new Tree255_verifyPreorder_stack().verifyPreorder(new int[]{2, 3, 0});
        System.out.println(b);
    }
}