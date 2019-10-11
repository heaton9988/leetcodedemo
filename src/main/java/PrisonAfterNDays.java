public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14;
        int[] ret = cells;

        for (int i = 0; i < N; i++) {
            int[] temp = new int[8];
            temp[0] = 0;
            temp[7] = 0;
            for (int j = 1; j < 7; j++) {
                temp[j] = ret[j - 1] - ret[j + 1] == 0 ? 1 : 0;
            }
            ret = temp;
        }
        return ret;
    }
//    public int[] prisonAfterNDays(int[] cells, int N) {
//        int[] ret = cells;
//        HashMap<Integer, Integer> score2index = new HashMap<>();
//
//        boolean matched = false;
//        for (int i = 0; i < N; i++) {
//            if (i < 20 || i > N - 10) {
//                print(i, ret);
//            }
//            int[] temp = new int[8];
//            temp[0] = 0;
//            temp[7] = 0;
//            for (int j = 1; j < 7; j++) {
//                temp[j] = ret[j - 1] - ret[j + 1] == 0 ? 1 : 0;
//            }
//            ret = temp;
//
//            int score = array2score(ret);
//            Integer prevIndex = score2index.get(score);
//            if (prevIndex != null && !matched) {
//                matched = true;
//                int step = i - prevIndex;
//                while (i + step < N) {
//                    i += step;
//                }
//            } else {
//                score2index.put(score, i);
//            }
//        }
//        return ret;
//    }

    public static int array2score(int[] a1) {
        int factor = 1;
        int score = 0;
        for (int i = 0; i < a1.length; i++) {
            score += a1[i] * factor;
            factor = factor * 10;
        }
        return score;
    }

    public static void print(int index, int[] arr) {
        System.out.println();
        System.out.print(index + "\t");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int N = 1000000000;
        int[] ints = new PrisonAfterNDays().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, N);

        System.out.println("\nfinal");
        print(N, ints);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}