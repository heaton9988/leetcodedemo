import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator284 implements Iterator<Integer> {
	int cur;
	List<Integer> list;

	public PeekingIterator284(Iterator<Integer> itr) {
		list = new ArrayList<Integer>();
		while (itr.hasNext()) {
			list.add(itr.next());
		}
	}

	public Integer peek() {
		if (list.isEmpty() || cur >= list.size()) {
			return -100000;
		}
		return list.get(cur);
	}

	@Override
	public Integer next() {
		int result = -100000;
		if (cur < list.size()) {
			result = list.get(cur++);
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		if (cur < list.size()) {
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
		Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
		PeekingIterator284 obj = new PeekingIterator284(iterator);
		long start = System.currentTimeMillis();
		int result1 = obj.next();
		int result2 = obj.peek();
		int result3 = obj.next();
		boolean b = obj.hasNext();
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}