import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0) return ret;
        for (int a : arr) ret.add(a);

        Collections.sort(ret, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Math.abs(a - x) - Math.abs(b - x);
            }
        });
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        FindKClosestElements658 obj = new FindKClosestElements658();
        long start = System.currentTimeMillis();
        List<Integer> closestElements = obj.findClosestElements(input, 4, 3);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}