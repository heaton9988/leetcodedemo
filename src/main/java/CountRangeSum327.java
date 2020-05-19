public class CountRangeSum327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] mark = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        long sum = 0;
        mark[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mark[i + 1] = sum;
        }
        return countRangeSum2(mark, temp, lower, upper, 0, mark.length - 1);
    }

    public int countRangeSum2(long[] mark, long[] temp, int lower, int upper, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int m = i + (j - i) / 2;
        //left i, m
        int left_sum = countRangeSum2(mark, temp, lower, upper, i, m);
        //right m+1, j
        int right_sum = countRangeSum2(mark, temp, lower, upper, m + 1, j);

        int sum = 0;
        int left = i;
        int l = m + 1;
        int h = m + 1;
        while (left <= m && l <= j) {
            if (mark[l] - mark[left] < lower) {
                l++;
                continue;
            }

            while (h <= j && mark[h] - mark[left] <= upper) {
                h++;
                continue;
            }
            sum += (h - l);
            left++;
        }

        // sort
        int f = i;
        int s = m + 1;
        int n = i;
        while (f <= m || s <= j) {
            if (f > m) {
                temp[n] = mark[s];
                n++;
                s++;
                continue;
            }
            if (s > j) {
                temp[n] = mark[f];
                n++;
                f++;
                continue;
            }
            if (mark[f] <= mark[s]) {
                temp[n] = mark[f];
                n++;
                f++;
            } else {
                temp[n] = mark[s];
                n++;
                s++;
            }
        }
        for (int k = i; k <= j; k++) {
            mark[k] = temp[k];
        }
        // System.out.println("i:" + i +" j:" + j + " sum:" + (left_sum + right_sum + sum));
        return left_sum + right_sum + sum;
    }

    public static void main(String[] args) {
        CountRangeSum327 obj = new CountRangeSum327();
        long start = System.currentTimeMillis();
        System.out.println(obj.countRangeSum(new int[]{-2, 5, 1}, -2, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}