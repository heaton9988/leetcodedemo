import java.util.Arrays;
import java.util.Stack;

public class MaxNumber321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int min = Math.max(0, k - nums2.length);
        int max = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = min; i <= max; i++) {
            System.out.println("i=" + i + ",k-i=" + (k - i));
            int[] n1 = max_k(nums1, i);
            int[] n2 = max_k(nums2, k - i);
            int[] n = merge(n1, n2);
            if (compare(n, ans)) {
                ans = n;
            }
        }
        return ans;
    }

    public boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length && i < arr2.length; i++) {
            if (arr1[i] > arr2[i]) return true;
            else if (arr1[i] < arr2[i]) return false;
        }
        return arr1.length > arr2.length;
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int len1 = arr1.length, len2 = arr2.length;
        int i, j, k;
        i = k = j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (compare(Arrays.copyOfRange(arr1, i, len1), Arrays.copyOfRange(arr2, j, len2))) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            res[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            res[k++] = arr2[j++];
        }
        return res;
    }

    public int[] max_k(int[] arr, int k) {
        if (k == 0) return new int[0];
        if (k == arr.length) return arr.clone();
        int drop = arr.length - k;
        int[] res = new int[k];
        Stack<Integer> st = new Stack<>();
        for (Integer ii : arr) {
            while (st.isEmpty() == false && drop > 0 && ii > st.peek()) {
                st.pop();
                drop--;
            }
            st.push(ii);
        }
        while (st.size() > k) st.pop();
        for (int i = k - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        MaxNumber321 obj = new MaxNumber321();
        long start = System.currentTimeMillis();
        System.out.println(obj.maxNumber(new int[]{1}, new int[]{6,7,8,9,0}, 6));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}