import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class X3SumClosest016 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				if (Math.abs(target - sum) < Math.abs(target - ans))
					ans = sum;
				if (sum > target)
					end--;
				else if (sum < target)
					start++;
				else
					return ans;
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		X3SumClosest016 obj = new X3SumClosest016();
		long start = System.currentTimeMillis();
		int i = obj.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1);
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}