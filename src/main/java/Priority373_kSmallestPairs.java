import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Priority373_kSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int i1 = 0, i2 = 0, len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len1 == 0 || len2 == 0) return res;

        while (i1 < len1 || i2 < len2) {
            res.add(Arrays.asList(nums1[i1], nums2[i2]));
            if (res.size() == k || (i1 == len1 - 1 && i2 == len2 - 1)) {
                break;
            }
            if (i1 == len1 - 1) {
                if (nums1[0] + nums2[i2 + 1] >= nums1[i1] + nums2[i2]) {
                    i1 = 0;
                }
                i2++;
            } else if (i2 == len2 - 1) {
                if (nums1[i1 + 1] + nums2[0] >= nums1[i1] + nums2[i2]) {
                    i2 = 0;
                }
                i1++;
            } else { // i1和i2都不是最后一个数
                if (nums1[i1] == nums1[i1 + 1]) {
                    i1++;
                } else if (nums2[i2] == nums2[i2 + 1]) {
                    i2++;
                } else { // 后面的数字
                    if (nums1[i1] + nums2[i2 + 1] < nums1[i1 + 1] + nums2[i2]) {
                        i2++;
                    } else {
                        i1++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Priority373_kSmallestPairs obj = new Priority373_kSmallestPairs();
        long start = System.currentTimeMillis();
        Object o = obj.kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 100);
//        Object o = obj.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
//        Object o = obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 9);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}