import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<List<Integer>> results = new ArrayList<>();

        boolean reverse = false;

        while (true) {
            List<TreeNode> allInThisLoop = new ArrayList<>();
            while (stack.size() > 0) {
                allInThisLoop.add(stack.pop());
            }
            if (allInThisLoop.size() == 0) {
                break;
            }
            ArrayList<Integer> ret = new ArrayList<>();
            if (reverse) {
                for (int i = 0; i < allInThisLoop.size(); i++) {
                    TreeNode treeNode = allInThisLoop.get(i);
                    if (treeNode != null) {
                        ret.add(treeNode.val);
                        stack.push(treeNode.right);
                        stack.push(treeNode.left);
                    }
                }
            } else {
                for (int i = 0; i < allInThisLoop.size(); i++) {
                    TreeNode treeNode = allInThisLoop.get(i);
                    if (treeNode != null) {
                        ret.add(treeNode.val);
                        stack.push(treeNode.left);
                        stack.push(treeNode.right);
                    }
                }
            }
            if (ret.size() > 0) {
                results.add(ret);
            }
            reverse = !reverse;
        }
        return results;
    }

    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] arr = new Integer[]{1, 2, 3, 4, null, null, 5};

        TreeNode treeNode = arr2tree(arr);

        long start = System.currentTimeMillis();
        List<List<Integer>> result = new ZigzagLevelOrder103().zigzagLevelOrder(treeNode);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }


    public static TreeNode arr2tree(Integer[] arr) {
        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            nodeArr[i] = new TreeNode(arr[i]);
            if (i != 0) {
                if (i % 2 == 0) {
                    nodeArr[(i - 1) / 2].right = nodeArr[i];
                } else {
                    nodeArr[(i - 1) / 2].left = nodeArr[i];
                }
            }
        }
        return nodeArr[0];
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
