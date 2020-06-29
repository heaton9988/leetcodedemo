public class Backtracking351_numberOfPatterns {
    int min, max;
    boolean[] visited = new boolean[10];
    int[][] start2end = new int[10][];
    int[][] check = new int[10][];

    {
        start2end[1] = new int[]{2, 4, 5, 6, 8};
        start2end[2] = new int[]{1, 3, 4, 5, 6, 7, 9};
        start2end[3] = new int[]{2, 5, 6, 4, 8};
        start2end[4] = new int[]{1, 2, 5, 7, 8, 3, 9};
        start2end[5] = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
        start2end[6] = new int[]{2, 3, 5, 8, 9, 1, 7};
        start2end[7] = new int[]{4, 5, 8, 2, 6};
        start2end[8] = new int[]{4, 5, 6, 7, 9, 1, 3};
        start2end[9] = new int[]{5, 6, 8, 2, 4};

        check[1] = new int[]{2, 3, 4, 7, 5, 9};
        check[2] = new int[]{5, 8};
        check[3] = new int[]{2, 1, 6, 9, 5, 7};
        check[4] = new int[]{5, 6};
        check[5] = new int[]{};
        check[6] = new int[]{5, 4};
        check[7] = new int[]{4, 1, 8, 9, 5, 3};
        check[8] = new int[]{5, 2};
        check[9] = new int[]{8, 7, 6, 3, 5, 1};
    }

    public int numberOfPatterns(int m, int n) {
        this.min = m;
        this.max = n;
        return 4 * helper(1, 0) + 4 * helper(2, 0) + helper(5, 0);
    }

    private int helper(int num, int preStep) {
        int step = preStep + 1;
        if (step == max) return 1;
        int res = step >= min ? 1 : 0;
        visited[num] = true;
        if (step < max) {
            for (int nextNum : start2end[num]) {
                if (visited[nextNum]) {
                    continue;
                }
                res += helper(nextNum, step);
            }
            int[] jumpArr = check[num];
            for (int i = 1; i < jumpArr.length; i += 2) {
                if (!visited[jumpArr[i - 1]] || visited[jumpArr[i]]) {
                    continue;
                }
                res += helper(jumpArr[i], step);
            }
        }
        visited[num] = false;
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Object o = new Backtracking351_numberOfPatterns().numberOfPatterns(1, 2);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}