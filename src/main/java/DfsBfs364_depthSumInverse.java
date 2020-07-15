import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsBfs364_depthSumInverse {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0)
            return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (int i = 0; i < nestedList.size(); i++) {
            queue.offer(nestedList.get(i));
        }

        int prev = 0;
        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    prev += nestedInteger.getInteger();
                } else {
                    for (NestedInteger temp : nestedInteger.getList()) {
                        queue.offer(temp);
                    }
                }
            }
            sum += prev;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedInteger(1));
        list.add(new NestedInteger().add(new NestedInteger(2)));
        new DfsBfs364_depthSumInverse().depthSumInverse(list);
        System.out.println();
    }

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
}
