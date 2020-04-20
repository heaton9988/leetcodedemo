public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate217 obj = new ContainsDuplicate217();
        long start = System.currentTimeMillis();

        Object v = obj.containsDuplicate(new int[]{6, 4, 3, 6});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}