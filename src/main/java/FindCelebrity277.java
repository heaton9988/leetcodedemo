import java.util.HashSet;
import java.util.TreeSet;

public class FindCelebrity277 {
    /**
     * @param n
     * @return -1: 没有名人    0 ~ n-1 有名人, 名人的编号
     */
    public int findCelebrity(int n) {
        HashSet notFamous = new HashSet();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (knows(i, j)) {
                    notFamous.add(i);
                } else {
                    notFamous.add(j);
                }
                if (notFamous.size() == n) return -1;
            }
        }

        outer:
        for (int i = 0; i < n; i++) {
            if (notFamous.contains(i)) continue;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (!knows(j, i)) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    private boolean knows(int a, int b) {
        int[][] arr = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        return arr[a][b] == 1;
    }


    public static void main(String[] args) {
        FindCelebrity277 obj = new FindCelebrity277();
        long start = System.currentTimeMillis();
        int i = obj.findCelebrity(5);
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}