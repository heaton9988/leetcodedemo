public class FindDuplicate287 {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 6, 6, 2, 3};
        FindDuplicate287 obj = new FindDuplicate287();
        long start = System.currentTimeMillis();
        System.out.println(obj.findDuplicate(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}