public class Tree255_verifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(int[] preorder, int start, int end, int greaterThan, int lessThan) {
        if (start > end) return true;
        int parent = preorder[start];

        Integer rightStart = null;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] <= greaterThan || preorder[i] >= lessThan) return false;
            if (preorder[i] > parent) {
                rightStart = i;
                break;
            }
        }
        if (rightStart == null) {
            return helper(preorder, start + 1, end, greaterThan, parent);
        } else {
            boolean left = helper(preorder, start + 1, rightStart - 1, greaterThan, parent);
            return left && helper(preorder, rightStart, end, parent, lessThan);
        }
    }

    public static void main(String[] args) {
        boolean b = new Tree255_verifyPreorder().verifyPreorder(new int[]{5, 2, 1, 3, 6});
//        boolean b = new Tree255_verifyPreorder().verifyPreorder(new int[]{2, 3, 1});
        System.out.println(b);
    }
}