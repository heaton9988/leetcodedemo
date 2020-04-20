import java.util.HashSet;

public class FindCelebrity277_2 {
    /**
     * @param n
     * @return -1: 没有名人    0 ~ n-1 有名人, 名人的编号
     */
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != res && (knows(res, i) || !knows(i, res))) {
                return -1;
            }
        }
        return res;
    }

    private boolean knows(int a, int b) {
        int[][] arr = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        return arr[a][b] == 1;
    }


    public static void main(String[] args) {
        FindCelebrity277_2 obj = new FindCelebrity277_2();
        long start = System.currentTimeMillis();
        int i = obj.findCelebrity(5);
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}