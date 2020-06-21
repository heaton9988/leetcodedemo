public class Tree331_isValidSerialization_2 {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        char[] chars = preorder.toCharArray();
        int slot = 1;
        for (int i = 0; i < chars.length; i++) {
            if (--slot < 0) return false;
            if (chars[i] != '#') {
                slot += 2;
            }
            while (i < chars.length && chars[i] != ',') i++;
        }
        return slot == 0;
    }

    public static void main(String[] args) {
        Object o = new Tree331_isValidSerialization_2().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
//        Object o = new Tree331_isValidSerialization().isValidSerialization("9,#,#,1");
//        Object o = new Tree331_isValidSerialization().isValidSerialization("1,#");
        System.out.println(o);
    }
}