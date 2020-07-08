import java.util.ArrayList;
import java.util.List;

public class BinarySearch278_firstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        List<Boolean> list = new ArrayList<Boolean>();
        list.add(false);
        list.add(false);
        list.add(false);
        list.add(true);
        list.add(true);
        return list.get(version - 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BinarySearch278_firstBadVersion obj = new BinarySearch278_firstBadVersion();
        System.out.println(obj.firstBadVersion(5)); // 1,5,2,6,3,7,4     0,2,4   4,5,6

//        obj.wiggleSort(new int[]{3, 3, 5, 5, 2, 2, 1, 1, 6, 6, 4, 4});
//        obj.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}