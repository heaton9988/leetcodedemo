import java.util.*;

public class BinarySearch315_countSmaller {
    int[] nums;
    int len;

    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        ArrayList<Integer> tmpList = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>(len);
        for (int i = len - 1; i >= 0; i--) {
            int index = binarySearch(tmpList, nums[i]);
            resList.add(index);
            tmpList.add(index, nums[i]);
        }
        Collections.reverse(resList);
        return resList;
    }

    private int binarySearch(ArrayList<Integer> list, int target) {
        if (list.size() == 0) {
            return 0;
        }
        int res = 0;
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == list.get(mid)) {
                res = mid;
                r = mid - 1;
            } else if (target < list.get(mid)) {
                res = mid;
                r = mid - 1;
            } else {
                res = mid + 1;
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BinarySearch315_countSmaller obj = new BinarySearch315_countSmaller();
        System.out.println(obj.countSmaller(new int[]{5, 2, 6, 1}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}