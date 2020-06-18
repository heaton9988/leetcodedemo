import util.TreeNode;
import util.Util;

import java.util.HashSet;
import java.util.Stack;

public class Tree173_BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public Tree173_BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */

    public static void main(String[] args) {
//        Tree173_BSTIterator iterator = new Tree173_BSTIterator(Util.arr2tree(new Integer[]{7, 3, 15, null, null, 9, 20}));
//        System.out.println(iterator.next());    // 返回 3
//        System.out.println(iterator.next());    // 返回 7
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 9
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 15
//        System.out.println(iterator.hasNext()); // 返回 true
//        System.out.println(iterator.next());    // 返回 20
//        System.out.println(iterator.hasNext()); // 返回 false

        Tree173_BSTIterator iterator = new Tree173_BSTIterator(Util.arr2tree(new Integer[]{3, 1, 4, null, 2}));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}