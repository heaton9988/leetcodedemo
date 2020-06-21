import util.TreeNode;

public class Tree331_isValidSerialization {
    int index = 0;
    String preorder;
    int n;
    Boolean result = null;

    public boolean isValidSerialization(String preorder) {
        this.preorder = preorder;
        this.n = preorder.length();
        dfs();
        return result == null ? index >= n : result;
    }

    private TreeNode dfs() {
        if (index >= n) {
            result = false;
            return null;
        }
        char c = preorder.charAt(index++);
        if (c == '#') {
            index++;
            return null;
        } else if (c >= '0' && c <= '9') {
            int sum = c - '0';
            while (index < n && (c = preorder.charAt(index++)) != ',') {
                sum = sum * 10 + (c - '0');
            }
            TreeNode node = new TreeNode(sum);
            if (index + 1 < n && preorder.charAt(index) == ',') {
                index++;
            }
            node.left = dfs();
            node.right = dfs();
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        Object o = new Tree331_isValidSerialization().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
//        Object o = new Tree331_isValidSerialization().isValidSerialization("9,#,#,1");
//        Object o = new Tree331_isValidSerialization().isValidSerialization("1,#");
        System.out.println(o);
    }
}