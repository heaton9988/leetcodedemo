import java.util.*;

public class Math264_nthUglyNumber {
    public static Ugly u = new Ugly();

    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }

    static class Ugly {
        public int[] nums = new int[1690];

        Ugly() {
            HashSet<Long> seen = new HashSet();
            PriorityQueue<Long> heap = new PriorityQueue<Long>();
            seen.add(1L);
            heap.add(1L);

            long currUgly, newUgly;
            int[] primes = new int[]{2, 3, 5};
            for (int i = 0; i < 1690; ++i) {
                currUgly = heap.poll();
                nums[i] = (int) currUgly;
                for (int j : primes) {
                    newUgly = currUgly * j;
                    if (!seen.contains(newUgly)) {
                        seen.add(newUgly);
                        heap.add(newUgly);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object o = new Math264_nthUglyNumber().nthUglyNumber(1690);
        System.out.println(o);
    }
}