import java.util.ArrayDeque;
import java.util.HashSet;

public class Math365_canMeasureWater_bfs {
    HashSet<String> put = new HashSet<>();
    HashSet<String> already = new HashSet<>();

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("0,0");
        put.add("0,0");

        while (!deque.isEmpty()) {
            String key = deque.pollFirst();
            boolean seenDot = false;
            int currX = key.charAt(0) - '0', currY = 0;
            int index = 1;
            while (index < key.length()) {
                char c = key.charAt(index++);
                if (c == ',') {
                    seenDot = true;
                } else if (seenDot) {
                    currY = currY * 10 + (c - '0');
                } else {
                    currX = currX * 10 + (c - '0');
                }
            }
            if (currX > x) {
                currY = currY + (currX - x);
                currX = x;
            }
            if (currY > y) {
                currX = currX + (currY - y);
                currY = y;
            }

            String currKey = currX + "," + currY;
            if (already.contains(currKey)) {
                continue;
            }
            if (currX == z || currY == z || currX + currY == z) return true;
            already.add(currKey);

            String nextKey = currX + "," + y;
            if (!put.contains(nextKey) && currY < y) { // 把y填满
                deque.addLast(nextKey);
                put.add(nextKey);
            }
            nextKey = x + "," + currY;
            if (!put.contains(nextKey) && currX < x) { // 把x填满
                deque.addLast(nextKey);
                put.add(nextKey);
            }
            nextKey = x + "," + y;
            if (!put.contains(nextKey) && (currX < x || currY < y)) { // 把x,y都倒满
                deque.addLast(nextKey);
                put.add(nextKey);
            }
            nextKey = "0," + currY;
            if (!put.contains(nextKey) && currX > 0) { // 把x清空
                deque.addLast(nextKey);
                put.add(nextKey);
            }
            nextKey = currX + ",0";
            if (!put.contains(nextKey) && currY > 0) { // 把y清空
                deque.addLast(nextKey);
                put.add(nextKey);
            }
//            nextKey = "0,0";
//            if (!put.contains(nextKey) && (currX > 0 || currY > 0)) { // 把x,y都清空
//                deque.addLast(nextKey);
//                put.add(nextKey);
//            }
            nextKey = (currX + currY) + ",0";
            if (!put.contains(nextKey) && currX < x && currY > 0) { // 把y倒进x
                deque.addLast(nextKey);
                put.add(nextKey);
            }
            nextKey = "0," + (currX + currY);
            if (!put.contains(nextKey) && currY < y && currX > 0) { // 把x倒进y
                deque.addLast(nextKey);
                put.add(nextKey);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        Object o = new Math365_canMeasureWater_dfs().canMeasureWater(2, 6, 5);
//        Object o = new Math365_canMeasureWater_dfs().canMeasureWater(3, 5, 4);
//        Object o = new Math365_canMeasureWater_bfs().canMeasureWater(104681, 104683, 54);
        Object o = new Math365_canMeasureWater_bfs().canMeasureWater(22003, 31237, 31238);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}