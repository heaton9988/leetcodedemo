import java.util.HashMap;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int line = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, 1 + count);
            }
            if (map.get(num) > line) return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement169 obj = new MajorityElement169();
        long start = System.currentTimeMillis();

        Object v = obj.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}