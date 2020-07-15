import java.util.List;

public class DfsBfs339_depthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(1, nestedList);
    }

    private int helper(int level, List<NestedInteger> list) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            } else {
                sum += helper(level + 1, ni.getList());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new DfsBfs339_depthSum().depthSum(null);
        System.out.println();
    }

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
