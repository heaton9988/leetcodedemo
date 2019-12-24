public class FloodFill733 {

    int oldColor;
    int newColor;
    int width;
    int height;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return null;
        if (image.length <= 1 || image[0].length <= 1) return image;
        this.height = image.length;
        this.width = image[0].length;

        if (sr >= 0 && sr < height && sc >= 0 && sc < width) {
            this.oldColor = image[sr][sc];
            if (this.oldColor == newColor) return image;
        } else {
            return image;
        }
        this.newColor = newColor;

        dfs(image, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i + 1, j);
        dfs(image, i - 1, j);
        dfs(image, i, j + 1);
        dfs(image, i, j - 1);
    }

    public static void main(String[] args) {
        FloodFill733 obj = new FloodFill733();
        int[][] image = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 0, 1}
        };
        long start = System.currentTimeMillis();
        int[][] ints = obj.floodFill(image, 1, 1, 2);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}