public class Design251_Vector2D {
    int[][] v;
    int i, j;
    Integer next;

    public Design251_Vector2D(int[][] v) {
        this.v = v;
        outer:
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                next = v[i][j];
                this.i = i;
                this.j = j;
                break outer;
            }
        }
    }

    public int next() {
        int res = next;
        int a = i, b = j + 1;
        outer:
        for (; a < v.length; a++) {
            for (; b < v[a].length; b++) {
                next = v[a][b];
                this.i = a;
                this.j = b;
                break outer;
            }
            b=0;
        }
        if (a >= v.length) {
            next = null;
        }
        return res;
    }

    public boolean hasNext() {
        return next != null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design251_Vector2D obj = new Design251_Vector2D(new int[][]{{1, 2}, {3}, {4}});
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}