import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Design284_PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer result = null;

    public Design284_PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
    }

    public Integer peek() {
        if (result == null) {
            result = iter.next();
        }
        return result;
    }

    @Override
    public Integer next() {
        if (result != null) {
            int res = result;
            result = null;
            return res;
        } else {
            return iter.next();
        }
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || result != null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}