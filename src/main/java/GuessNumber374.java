public class GuessNumber374 {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= n) {
            int m = l + (r - l) / 2;
            int result = guess(m);
            if (result == 0) {
                return m;
            } else if (result > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    int guess(int num) {
        int answer = 6;
        if (num > answer) return -1;
        else if (num < answer) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GuessNumber374 obj = new GuessNumber374();
        System.out.println(obj.guessNumber(10));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}