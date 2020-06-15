import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;

/**
 * 这题用dfs总是超时, bfs偏向求出最少step的解
 */
public class Math365_canMeasureWater_bfs {
    HashSet<State> put = new HashSet<>();

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        ArrayDeque<State> deque = new ArrayDeque<>();
        deque.add(new State(0, 0));
        put.add(new State(0, 0));

        while (!deque.isEmpty()) {
            State key = deque.pollFirst();
            int currX = key.x, currY = key.y;
            if (currX > x) {
                currY = currY + (currX - x);
                currX = x;
            }
            if (currY > y) {
                currX = currX + (currY - y);
                currY = y;
            }

            if (currX == z || currY == z || currX + currY == z) return true;

            State state = new State(currX, y);
            if (!put.contains(state) && currY < y) { // 把y填满
                deque.addLast(state);
                put.add(state);
            }
            state = new State(x, currY);
            if (!put.contains(state) && currX < x) { // 把x填满
                deque.addLast(state);
                put.add(state);
            }
            state = new State(x, y);
            if (!put.contains(state) && (currX < x || currY < y)) { // 把x,y都倒满
                deque.addLast(state);
                put.add(state);
            }
            state = new State(0, currY);
            if (!put.contains(state) && currX > 0) { // 把x清空
                deque.addLast(state);
                put.add(state);
            }
            state = new State(currX, 0);
            if (!put.contains(state) && currY > 0) { // 把y清空
                deque.addLast(state);
                put.add(state);
            }
            state = new State(currX + currY, 0);
            if (!put.contains(state) && currX < x && currY > 0) { // 把y倒进x
                deque.addLast(state);
                put.add(state);
            }
            state = new State(0, currX + currY);
            if (!put.contains(state) && currY < y && currX > 0) { // 把x倒进y
                deque.addLast(state);
                put.add(state);
            }
        }
        return false;
    }

    private class State {
        public int x;
        public int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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