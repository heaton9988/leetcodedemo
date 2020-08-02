public class UnionFind323_countComponents {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }
        int[] parentNum = new int[n];
        int[] rankNun = new int[n];
        for (int i = 0; i < n; ++i) {
            parentNum[i] = i;
            rankNun[i] = 0;
        }
        for (int i = 0; i < edges.length; ++i) {
            unoinCom(edges[i][0], edges[i][1], parentNum, rankNun);
        }
        int timeVal = 0;
        for (int i = 0; i < n; ++i) {
            if (parentNum[i] == i) {
                timeVal++;
            }
        }
        return timeVal;
    }

    private int getParent(int inVal, int[] parentNum) {
        int temVal = inVal;
        while (temVal != parentNum[temVal]) {
            temVal = parentNum[temVal];
        }
        return temVal;
    }

    private void unoinCom(int fristVal, int secVal, int[] parentNum, int[] rankNum) {
        int xxPos = getParent(fristVal, parentNum);
        int yyPos = getParent(secVal, parentNum);
        if (xxPos == yyPos) {
            return;
        }
        if (rankNum[xxPos] < rankNum[yyPos]) {
            parentNum[xxPos] = yyPos;
        } else {
            parentNum[yyPos] = xxPos;
            if (rankNum[xxPos] == rankNum[yyPos]) {
                rankNum[xxPos]++;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind323_countComponents obj = new UnionFind323_countComponents();
        System.out.println(obj.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}