import util.TreeNode;

public class Tree108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        return helper(nums, 0, n - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (end - start) / 2 + start;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = helper(nums, start, mid - 1);
        res.right = helper(nums, mid + 1, end);
        return res;
    }

    public static void main(String[] args) {
        Object o = new Tree108_sortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(o);
    }
}