import java.lang.annotation.ElementType;
import java.util.*;

public class Math015_threeSum_2point {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Bean> beans = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0 || nums[n - 1] < 0) break;
            int target = 0 - nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    beans.add(new Bean(nums[i], nums[l], nums[r]));
                    l++;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Bean b : beans) {
            res.add(Arrays.asList(b.x, b.y, b.c));
        }
        return res;
    }

    class Bean {
        int x;
        int y;
        int c;

        Bean(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            Bean bean = (Bean) o;
            return x == bean.x && y == bean.y && c == bean.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, c);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        Object o = new Math015_threeSum_2point().threeSum(arr);
        System.out.println(o);
    }
}