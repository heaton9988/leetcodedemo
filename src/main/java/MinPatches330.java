public class MinPatches330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 10};
        MinPatches330 obj = new MinPatches330();
        long start = System.currentTimeMillis();
        System.out.println(obj.minPatches(arr, 20));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}