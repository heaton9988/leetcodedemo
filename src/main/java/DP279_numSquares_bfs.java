import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DP279_numSquares_bfs {
    public int numSquares(int n) {
        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) square_nums.add(i * i);

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder < square) {
                        break;
                    } else if (remainder < square) {
                        next_queue.add(remainder - square);
                    } else {
                        return level;
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP279_numSquares_bfs().numSquares(10);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}