public class UniquePath062 {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) return 0;
        if (m == 1 && n == 1) return 1;
        return _uniquePaths(m - 1, n - 1);
    }

    private int _uniquePaths(int rightSteps, int downSteps) {
        if (rightSteps == 0 && downSteps == 0) return 0;
        if (rightSteps == 1 && downSteps == 0) return 1;
        if (rightSteps == 0 && downSteps == 1) return 1;
        int rightWays = rightSteps < 1 ? 0 : _uniquePaths(rightSteps - 1, downSteps);
        int downWays = downSteps < 1 ? 0 : _uniquePaths(rightSteps, downSteps - 1);
        return rightWays + downWays;
    }

    public static void main(String[] args) {
        UniquePath062 obj = new UniquePath062();
        long start = System.currentTimeMillis();
        System.out.println(obj.uniquePaths(3, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}