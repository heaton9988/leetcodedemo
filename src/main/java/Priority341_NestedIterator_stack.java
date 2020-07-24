import java.util.*;

public class Priority341_NestedIterator_stack implements Iterator<Integer> {
    static class NestedInteger {
        Integer val;
        List<NestedInteger> list = new ArrayList<>();

        NestedInteger(int val) {
            this.val = val;
        }

        NestedInteger() {
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return val;
        }

        public NestedInteger add(NestedInteger ni) {
            list.add(ni);
            return this;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    ArrayDeque<NestedInteger> deque = new ArrayDeque<>();

    public Priority341_NestedIterator_stack(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            deque.addLast(ni);
        }
    }

    @Override
    public Integer next() {
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (deque.size() == 0) return false;
        while (deque.size() > 0 && !deque.peekFirst().isInteger()) {
            List<NestedInteger> list = deque.pollFirst().getList();
            Collections.reverse(list);
            for (NestedInteger ni : list) {
                deque.addFirst(ni);
            }
        }
        return deque.size() > 0;
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedInteger ni1 = new NestedInteger();
        ni1.list.add(new NestedInteger(1));
        ni1.list.add(new NestedInteger(2));
        nestedList.add(ni1);

        NestedInteger ni2 = new NestedInteger(3);
        nestedList.add(ni2);

        NestedInteger ni3 = new NestedInteger();
        ni3.list.add(new NestedInteger(4));
        ni3.list.add(new NestedInteger(5));
        nestedList.add(ni3);


        long start = System.currentTimeMillis();

        Priority341_NestedIterator_stack i = new Priority341_NestedIterator_stack(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}