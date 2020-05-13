public class Trap042 {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int toppest = 0;
        for (int i = 1; i < n; i++) {
            toppest = Math.max(toppest, height[i - 1]);
            left[i] = toppest;
        }
        toppest = 0;
        for (int i = n - 2; i >= 0; i--) {
            toppest = Math.max(toppest, height[i + 1]);
            right[i] = toppest;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int area = Math.min(left[i], right[i]) - height[i];
            if (area > 0) res += area;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap042 obj = new Trap042();
        long start = System.currentTimeMillis();
        System.out.println(obj.trap(arr));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}