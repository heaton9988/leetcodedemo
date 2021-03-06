import java.util.ArrayList;
import java.util.List;

public class DP120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int width = triangle.get(height - 1).size();
        int[] dp = new int[width + 1];
        for (int i = height - 1; i >= 0; i--) {
            List<Integer> currList = triangle.get(i);

            for (int j = 0; j < currList.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + currList.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {{
            add(2);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        Object o = new DP120_minimumTotal().minimumTotal(triangle);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}