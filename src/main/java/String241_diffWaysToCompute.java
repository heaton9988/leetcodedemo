import java.util.ArrayList;
import java.util.List;

public class String241_diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] cs = input.toCharArray();
        int n = cs.length;
        List<Character> ops = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (isOp(c)) {
                nums.add(num);
                num = 0;
                ops.add(c);
            } else {
                num = num * 10 + (c - '0');
            }
        }
        nums.add(num);
        int N = nums.size();
        ArrayList<Integer>[][] dp = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = new ArrayList();
            dp[i][i].add(nums.get(i));
        }
//        dp[0][1] = (dp[0][0],dp[1][1])
//        dp[0][2] = (dp[0][0],dp[1][2]), (dp[0][1],dp[2][2])
        //dp[0][3]
        for (int step = 1; step < N; step++) {
            for (int i = 0; i < N - step; i++) {
                int j = i + step;

                dp[i][j] = new ArrayList<>();
                for (int m = i; m < j; m++) {
                    ArrayList<Integer> list1 = dp[i][m];
                    ArrayList<Integer> list2 = dp[m + 1][j];
                    for (int a = 0; a < list1.size(); a++) {
                        for (int b = 0; b < list2.size(); b++) {
                            dp[i][j].add(caculate(list1.get(a), list2.get(b), ops.get(m)));
                        }
                    }
                }
            }
        }
        res = dp[0][N - 1];
        return res;
    }

    private Integer caculate(Integer a1, Integer a2, char op) {
        switch (op) {
            case '+':
                return a1 + a2;
            case '-':
                return a1 - a2;
            case '*':
                return a1 * a2;
        }
        return -1;
    }

    private boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String241_diffWaysToCompute().diffWaysToCompute("2*3-4*5");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}