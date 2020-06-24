public class Backtracking060_getPermutation {
    public String getPermutation(int n, int k) {
        int[] mul = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        int[] visted = new int[n + 1];
        StringBuilder ss = new StringBuilder("");
        int i = n - 1;
        while (k > 0 && i >= 0) {
            int index = 1;
            while (k > mul[i]) {
                k = k - mul[i];
                index++;
            }
            int indexVisted = 0, j = 1;
            while (j < n + 1 && indexVisted < index) {
                if (visted[j] == 0)
                    indexVisted++;
                j++;
            }
            visted[j - 1] = 1;
            ss.append(j - 1);
            i--;
        }
        return ss.toString();
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking060_getPermutation().getPermutation(4, 9);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}