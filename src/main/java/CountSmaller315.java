import java.util.*;

public class CountSmaller315 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        HashMap<Integer, Integer> num2rank = new HashMap();
        int rank = 1;
        for (Integer num : set) num2rank.put(num, rank++);

        List<Integer> res = new ArrayList<>();

        int[] freq = new int[num2rank.size() + 1];
        for (int i = n - 1; i >= 0; i--) {
            int index = num2rank.get(nums[i]);
            freq[index]++;
            int sum = 0;
            for (int j = 0; j < index; j++) sum += freq[j];
            res.add(sum);
        }
        Collections.reverse(res);
        return res;
    }

    private int insertTemp(List<Integer> temp, int value) {
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CountSmaller315 obj = new CountSmaller315();
        System.out.println(obj.countSmaller(new int[]{5, 2, 6, 1}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}