package tony2;

public class BinarySearchTree {
    int totalWeight = 0;
    int savedSteps=0;

    // min is inclusive, max is inclusive
    public int totalWeight(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }

        _totalWeight(root, min, max);

        return totalWeight;
    }

    private void _totalWeight(TreeNode curr, int min, int max) {
        if (curr == null) return;
        if (curr.val >= min && curr.val <= max) {
            totalWeight += curr.val;
        }

        if (curr.val >= min) {
            _totalWeight(curr.left, min, max);
        }else{
            savedSteps++;
        }
        if (curr.val <= max) {
            _totalWeight(curr.right, min, max);
        }else {
            savedSteps++;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();

        Integer[] arr = new Integer[]{10, 5, 15, 3, 7, null, 18}; int min=7,max=15;
//        Integer[] arr = new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6};
//        int min = 6, max = 10;

        int result = obj.totalWeight(arr2tree(arr), min, max);

        System.out.println(result);
        System.out.println(obj.savedSteps);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
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
}
