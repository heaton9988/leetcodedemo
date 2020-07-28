import java.util.HashSet;

public class Bit137_singleNumber_2 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sumSet = 0, sumAll = 0;
        for (int num : nums) {
            set.add(num);
            sumAll += num;
        }
        for (int num : set) sumSet += num;
        return (3 * sumSet - sumAll) / 2;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Bit137_singleNumber_2 obj = new Bit137_singleNumber_2();
        System.out.println(obj.singleNumber(new int[]{1, 1, 1, 5})); // 964176192
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}