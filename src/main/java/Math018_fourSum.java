import java.util.*;

public class Math018_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;// 去重

            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) break;
            int max = nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (max < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;// 去重
                int l = j + 1, r = n - 1;
                int min2 = nums[i] + nums[j] + nums[l] + nums[l + 1];
                if (min2 > target) continue;
                int max2 = nums[i] + nums[j] + nums[r] + nums[r - 1];
                if (max2 < target) continue;

                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new Math018_fourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(o);
    }
}