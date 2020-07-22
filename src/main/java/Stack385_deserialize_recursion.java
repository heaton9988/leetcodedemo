import java.util.ArrayList;
import java.util.List;

public class Stack385_deserialize_recursion {
    char[] chars; // 递归函数通过字符数组和cur下标确定要处理的位置
    int cur = 0;

    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        //本身不是一个集合而是一个整数的情况
        if (chars[0] != '[') return new NestedInteger(Integer.valueOf(s));
        //调用递归函数返回根集合
        return getNest();
    }

    public NestedInteger getNest() {
        NestedInteger nest = new NestedInteger();
        int num = 0;//num用于缓存用逗号分割的整数类型的值
        int sign = 1;//当前记录的整数的符号，1代表整数，-1代表负数
        while (cur != chars.length - 1) {
            cur++;
            if (chars[cur] == ',') {
                continue;
            }
            if (chars[cur] == '[') {
                nest.add(getNest());//遇到[递归获取子集合
            } else if (chars[cur] == ']') {
                return nest;
            } else if (chars[cur] == '-') {
                sign = -1;
            } else {//是数字的情况
                num = 10 * num + sign * (chars[cur] - '0');
                //如果下一个字符是,或者]说明当前数字已经记录完了，需要加入集合中
                if (chars[cur + 1] == ',' || chars[cur + 1] == ']') {
                    nest.add(new NestedInteger(num));
                    num = 0;
                    sign = 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Stack385_deserialize_recursion obj = new Stack385_deserialize_recursion();
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