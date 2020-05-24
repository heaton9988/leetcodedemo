import java.util.Arrays;

public class WiggleSort324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, n);


        if (n % 2 == 0) {
            for (int i = 0; i < n / 2 / 2; i++) {
                swap(copy, i, n / 2 - 1 - i);
            }
            for (int i = n / 2; i < n / 2 + n / 2 / 2; i++) {
                swap(copy, i, n / 2 + n - 1 - i);
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[i] = copy[i / 2];
                } else {
                    nums[i] = copy[n / 2 + i / 2];
                }
            }
        } else {
            for (int i = 0; i < (1 + n) / 2 / 2; i++) {
                swap(copy, i, (1 + n) / 2 - 1 - i);
            }
            for (int i = (1 + n) / 2; i < (1 + n) / 2 + (1 + n) / 2 / 2; i++) {
                swap(copy, i, n - 1 + (1 + n) / 2 - i);
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[i] = copy[i / 2];
                } else {
                    nums[i] = copy[1 + n / 2 + i / 2];
                }
            }
        }

        System.out.println();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        WiggleSort324 obj = new WiggleSort324();
        obj.wiggleSort(new int[]{1, 2, 3, 4, 5, 6, 7}); // 1,5,2,6,3,7,4     0,2,4   4,5,6

//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}