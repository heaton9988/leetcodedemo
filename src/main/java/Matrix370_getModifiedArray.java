public class Matrix370_getModifiedArray {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if (updates.length == 0) return res;
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < length) {
                res[update[1] + 1] -= update[2];
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                new int[]{1, 3, 2}
                , new int[]{2, 4, 3}
                , new int[]{0, 2, -2}
        };
        int[] modifiedArray = new Matrix370_getModifiedArray().getModifiedArray(5, arr1);
        System.out.println(modifiedArray);
    }
}