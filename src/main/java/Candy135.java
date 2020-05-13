import java.util.Arrays;

public class Candy135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res[] = new int[n];

        Arrays.fill(res, 1);
        while (true) {
            int error = 0;
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && res[i] <= res[i - 1]) {
                    res[i] = res[i - 1] + 1;
                    error++;
                }
                if (i < n - 1 && ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                    res[i] = res[i + 1] + 1;
                    error++;
                }
            }
            if (error == 0) break;
        }

        int ret = 0;
        for (int r : res) ret += r;
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
        Candy135 obj = new Candy135();
        long start = System.currentTimeMillis();
        System.out.println(obj.candy(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}