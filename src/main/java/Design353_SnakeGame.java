import java.util.HashSet;
import java.util.LinkedList;

public class Design353_SnakeGame {
    LinkedList<int[]> queue;
    int rows, cols;
    int[][] food;
    int foodIndex;
    HashSet<Integer> set;

    public Design353_SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;
        foodIndex = 0;
        queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        set = new HashSet<>();
        set.add(0);
    }

    public int move(String direction) {
        int[] head = queue.peekFirst();
        int nextRow = head[0], nextCol = head[1];
        if (direction.equals("R")) {
            nextCol++;
        } else if (direction.equals("L")) {
            nextCol--;
        } else if (direction.equals("U")) {
            nextRow--;
        } else if (direction.equals("D")) {
            nextRow++;
        }
        if (nextCol < 0 || nextCol >= cols || nextRow < 0 || nextRow >= rows) return -1;

        if (foodIndex < food.length && nextRow == food[foodIndex][0] && nextCol == food[foodIndex][1]) {
            foodIndex++;
        } else {
            int[] last = queue.removeLast();
            set.remove(last[0] * cols + last[1]);
        }
        int key = nextRow * cols + nextCol;
        if (set.contains(key)) return -1;
        queue.addFirst(new int[]{nextRow, nextCol});
        set.add(key);
        return foodIndex;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        "SnakeGame", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move"]
//[[3, 3,[[0, 1],[0, 2],[1, 2],[2, 2],[2, 1],[2, 0],[1, 0]]],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["U"],["R"],["R"],[
//        "D"],["D"],["L"],["L"],["U"],["R"],["U"],["L"],["D"]]

        Design353_SnakeGame snake = new Design353_SnakeGame(3, 3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}});
        System.out.println(snake.move("R"));//1
        System.out.println(snake.move("R"));//2
        System.out.println(snake.move("D"));//3
        System.out.println(snake.move("D"));//4
        System.out.println(snake.move("L"));//5
        System.out.println(snake.move("L"));//6
        System.out.println(snake.move("U"));//7
        System.out.println(snake.move("U"));//7
        System.out.println(snake.move("R"));//7
        System.out.println(snake.move("R"));//7
        System.out.println(snake.move("D"));//7
        System.out.println(snake.move("D"));//7
        System.out.println(snake.move("L"));//7  -1
        System.out.println(snake.move("L"));//7
        System.out.println(snake.move("U"));//
        System.out.println(snake.move("R"));//
        System.out.println(snake.move("U"));//
        System.out.println(snake.move("L"));//
        System.out.println(snake.move("D"));//

//        Design353_SnakeGame snake = new Design353_SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
//        Design353_SnakeGame snake = new Design353_SnakeGame(2, 2, new int[][]{{0, 1}});
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("D"));
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("U"));
//        System.out.println(snake.move("L"));
//        System.out.println(snake.move("U"));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}