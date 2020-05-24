import java.util.Arrays;

public class WiggleSort280 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean up = false;
        for (int j = 1; j + 1 < n; j++) {
            if (!up) { // 下降
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            up = !up;
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
        WiggleSort280 obj = new WiggleSort280();
        obj.wiggleSort(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5});
//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}