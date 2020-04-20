import java.util.ArrayList;
import java.util.List;

public class MajorityElement229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) return res;

        int len = nums.length;
        int cand1 = nums[0], cand2 = nums[0];
        int count1 = 0, count2 = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == cand1) {
                count1++;
                continue;
            }
            if (nums[i] == cand2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                cand1 = nums[i];
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                cand2 = nums[i];
                count2 = 1;
                continue;
            }

            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (cand1 == nums[i]) {
                count1++;
            } else if (cand2 == nums[i]) {
                count2++;
            }
        }
        if (count1 > len / 3) res.add(cand1);
        if (count2 > len / 3) res.add(cand2);

        return res;
    }

    public static void main(String[] args) {
        MajorityElement229 obj = new MajorityElement229();
        long start = System.currentTimeMillis();

        Object v = obj.majorityElement(new int[]{1, 1, 1, 2, 3, 4, 5, 6});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}