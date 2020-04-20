public class RemoveDuplicates080 {
    public int removeDuplicates(int[] nums) {
        Integer lastRead = null;
        int count = 0;
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lastRead != null) {
                if (lastRead.equals(nums[i])) {
                    count++;
                } else {
                    // do something
                    count = count > 2 ? 2 : count;
                    for (int j = 0; j < count - 1; j++) {
                        nums[writeIndex++] = lastRead;
                    }
                    lastRead = nums[i];
                    count = 1;
                    nums[writeIndex++] = nums[i];
                }
            } else {
                lastRead = nums[i];
                count = 1;
                nums[writeIndex++] = nums[i];
            }
        }
        if (count >= 2) {
            count = count > 2 ? 2 : count;
            for (int j = 0; j < count - 1; j++) {
                nums[writeIndex++] = lastRead;
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicates080 obj = new RemoveDuplicates080();
        long start = System.currentTimeMillis();
        int i = obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}