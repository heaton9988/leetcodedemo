import java.util.TreeSet;

public class Priority313_nthSuperUglyNumber_heap {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> pq = new TreeSet<>();
        int count = 0;
        pq.add(1L);
        long min = 1;
        while (true) {
            min = pq.pollFirst();
            count++;
            if (count >= n) break;
            for (int prime : primes) {
                pq.add(min * prime);
            }
        }
        return (int) min;
    }

    public static void main(String[] args) throws Exception {
        Priority313_nthSuperUglyNumber_heap obj = new Priority313_nthSuperUglyNumber_heap();
        long start = System.currentTimeMillis();
//        Object o = obj.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        Object o = obj.nthSuperUglyNumber(2, new int[]{2, 3, 5});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}