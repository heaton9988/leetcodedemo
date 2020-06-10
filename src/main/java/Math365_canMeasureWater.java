import java.util.ArrayDeque;
import java.util.HashSet;

public class Math365_canMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == y) return y == z;
        if (x > y) return canMeasureWater(y, x, z);
        if (x == z || y == z) return true;
        HashSet<Integer> already = new HashSet<>();
        already.add(x);
        already.add(y);
        ArrayDeque<Integer> list = new ArrayDeque();
        list.add(y - x);
        already.add(y - x);
        while (!list.isEmpty()) {
            Integer newVal = list.poll();
            if (newVal.equals(z)) return true;
            if (newVal.equals(x) || newVal.equals(y)) continue;
            if (x > newVal) {
                int a = y - (x - newVal);
                if (a > 0 && !already.contains(a)) {
                    if (a == z) return true;
                    list.add(a);
                    already.add(a);
                }
            }
            if (y > newVal) {
                int b = x - (y - newVal);
                if (b > 0 && !already.contains(b)) {
                    if (b == z) return true;
                    list.add(b);
                    already.add(b);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Object o = new Math365_canMeasureWater().canMeasureWater(2, 6, 5);

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}