import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int num = citations[i];
            if (num >= count + 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HIndex274 obj = new HIndex274();
        long start = System.currentTimeMillis();

        Object v = obj.hIndex(new int[]{100});
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}