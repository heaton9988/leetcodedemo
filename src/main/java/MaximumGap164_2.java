import java.util.ArrayList;
import java.util.List;

public class MaximumGap164_2 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        radixSort(nums);
        int res = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public void radixSort(int[] input) {
        final int RADIX = 10;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            // move to next digit
            placement *= RADIX;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 1};
        MaximumGap164_2 obj = new MaximumGap164_2();
        long start = System.currentTimeMillis();
        System.out.println(obj.maximumGap(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}