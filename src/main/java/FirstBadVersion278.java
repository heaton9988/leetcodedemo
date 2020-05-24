import java.util.ArrayList;
import java.util.List;

public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        return helper(0, n - 1);
    }

    private int helper(int start, int end) {
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1)) {
                return mid;
            } else {
                return helper(start, mid - 1);
            }
        } else {
            if (isBadVersion(mid + 1)) {
                return mid + 1;
            } else {
                return helper(mid + 1, end);
            }
        }
    }

    private boolean isBadVersion(int version) {
        List<Boolean> list = new ArrayList<Boolean>();
        list.add(false);
        list.add(false);
        list.add(false);
        list.add(true);
        list.add(true);
        return list.get(version);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FirstBadVersion278 obj = new FirstBadVersion278();
        obj.firstBadVersion(5); // 1,5,2,6,3,7,4     0,2,4   4,5,6

//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}