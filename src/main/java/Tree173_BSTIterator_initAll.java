import util.TreeNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree173_BSTIterator_initAll {
    List<Integer> list;
    int index;

    public Tree173_BSTIterator_initAll(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        inorder(root);
    }

    private void inorder(TreeNode node) {
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(index++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < list.size();
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

        Tree173_BSTIterator_initAll iterator = new Tree173_BSTIterator_initAll(Util.arr2tree(new Integer[]{3, 1, 4, null, 2}));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}