import java.util.Arrays;
import java.util.List;

public class Design281_ZigzagIterator {
    List<Integer> v1, v2;
    int i1, i2;
    int size1, size2;

    public Design281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        i1 = 0;
        i2 = 0;
        size1 = v1.size();
        size2 = v2.size();
    }

    public int next() {
        int res = 0;
        if (i1 == size1 || (i1 > i2 && i2 < size2)) {
            res = v2.get(i2++);
        } else if (i2 == size2 || (i1 == i2 && i1 < size1)) {
            res = v1.get(i1++);
        }
        return res;
    }

    public boolean hasNext() {
        return i1 < size1 || i2 < size2;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Design281_ZigzagIterator obj = new Design281_ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
        Design281_ZigzagIterator obj = new Design281_ZigzagIterator(Arrays.asList(1, 2), Arrays.asList());

        while (obj.hasNext()) {
            System.out.println(obj.next());
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}