import java.util.HashMap;

public class ContainsDuplicate219 {
    public boolean containsDuplicate(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer lastIndex = map.get(num);
            if (lastIndex != null) {
                min = Math.min(min, i - lastIndex);
            }
            map.put(num, i);
        }
        return min <= k;
    }

    public static void main(String[] args) {
        ContainsDuplicate219 obj = new ContainsDuplicate219();
        long start = System.currentTimeMillis();

        Object v = obj.containsDuplicate(new int[]{1, 0, 1, 1}, 1);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}