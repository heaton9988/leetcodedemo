import java.util.ArrayList;

public class DP312_maxCoins {
    ArrayList<Integer> list = new ArrayList<>();
    int len;
    int maxScoreIndex = -1;

    public int maxCoins(int[] nums) {
        len = nums.length;
        for (int num : nums) list.add(num);

        int res = 0;

        for (int i = 0; i < len; i++) {
            res += score();
            list.remove(maxScoreIndex);
        }
        return res;
    }

    private int score() {
        double max = Double.MIN_VALUE;
        int maxValue = 0;
        int size = list.size();
        double[] temp = new double[size];
        for (int i = 0; i < size; i++) {
            double left = i == 0 ? 1 : list.get(i - 1);
            double right = i == size - 1 ? 1 : list.get(i + 1);
            double curr = left * right / list.get(i);
            temp[i] = curr;
            if (curr > max) {
                max = curr;
                maxScoreIndex = i;
                maxValue = (int) (left * right * list.get(i));
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new DP312_maxCoins().maxCoins(new int[]{9, 76, 64});
//        Object o = new DP312_maxCoins().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}