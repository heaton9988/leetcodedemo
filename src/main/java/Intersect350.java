import java.util.ArrayList;
import java.util.Arrays;

public class Intersect350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, r = 0;
        while (l < n1 && r < n2) {
            if (nums1[l] == nums2[r]) {
                res.add(nums1[l++]);
                r++;
            } else if (nums1[l] > nums2[r]) {
                r++;
            } else {
                l++;
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Intersect350 obj = new Intersect350();
        System.out.println(obj.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}