import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack385_deserialize {
    public NestedInteger deserialize(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (cs[0] != '[') {
            NestedInteger ni = new NestedInteger(Integer.parseInt(s));
            return ni;
        }
        Object[] arr = new Object[len / 2 + 1];
        int sizeArr = 0;
        Integer sum = null;
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == '-') {
                sign = -1;
            } else if (c >= '0' && c <= '9') {
                if (sum == null) {
                    sum = c - '0';
                } else {
                    sum = sum * 10 + c - '0';
                }
            } else {
                if (sum != null) {
                    arr[sizeArr++] = sum * sign;
                    sum = null;
                    sign = 1;
                }
                if (c == ',') continue;

                if (c == ']') {
                    LinkedList<NestedInteger> list = new LinkedList<>();
                    while (!(arr[sizeArr - 1] instanceof Character) || (char) arr[sizeArr - 1] != '[') {
                        if (arr[sizeArr - 1] instanceof Integer) {
                            list.addFirst(new NestedInteger((Integer) arr[--sizeArr]));
                        } else if (arr[sizeArr - 1] instanceof NestedInteger) {
                            list.addFirst((NestedInteger) arr[--sizeArr]);
                        }
                    }
                    sizeArr--; // 把 '[' 从stack中pop出来

                    NestedInteger curr = new NestedInteger();
                    for (NestedInteger ni : list) curr.add(ni);
                    arr[sizeArr++] = curr;
                } else {
                    arr[sizeArr++] = c;
                }
            }
        }
        return (NestedInteger) arr[--sizeArr];
    }

    public static void main(String[] args) {
        Stack385_deserialize obj = new Stack385_deserialize();
        long start = System.currentTimeMillis();
//        Object o = obj.deserialize("324");
//        Object o = obj.deserialize("[[]]");
        Object o = obj.deserialize("[123,456,[788,799,833],[[]],10,[]]");
//        Object o = obj.deserialize("[-123,[456,[789]]]");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
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