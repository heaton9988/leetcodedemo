import java.util.HashSet;

public class LongestConsecutive128_On {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 1;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + count)) {
                    count++;
                }
                if (count > res) res = count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2};
        LongestConsecutive128_On obj = new LongestConsecutive128_On();
        long start = System.currentTimeMillis();
        System.out.println(obj.longestConsecutive(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}