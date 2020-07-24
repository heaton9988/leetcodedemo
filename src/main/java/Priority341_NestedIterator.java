import java.util.*;

public class Priority341_NestedIterator implements Iterator<Integer> {
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

    List<Integer> list;
    int index = 0;

    public Priority341_NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger ni : nestedList) dfs(list, ni);
    }

    void dfs(List<Integer> list, NestedInteger nestedList) {
        if (nestedList.isInteger()) {
            list.add(nestedList.getInteger());
        } else {
            List<NestedInteger> niList = nestedList.getList();
            for (int i = 0, size = niList.size(); i < size; i++) {
                dfs(list, niList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
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

        Priority341_NestedIterator i = new Priority341_NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}