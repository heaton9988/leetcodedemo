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
        if (j >= v[i].length - 1) {
            if (i >= v.length - 1) {
                next = null;
            } else {
                while (true) {
                    i++;
                    if (i == v[i].length) {
                        next = null;
                        break;
                    }
                    if (v[i].length > 0) break;
                }
                j = 0;
            }
        } else {
            j++;
        }
        if (next != null) {
            next = v[i][j];
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