public class Stack402_removeKdigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k >= len) return "0";
        char[] stack = new char[len];
        int size = 0;
        char[] cs = num.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            while (k > 0 && size > 0 && c < stack[size - 1]) {
                k--;
                size--;
            }
            stack[size++] = c;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size - k; i++) {
            if (stack[i] == '0' && res.length() == 0) continue;
            res.append(stack[i]);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) throws Exception {
        Stack402_removeKdigits obj = new Stack402_removeKdigits();
        long start = System.currentTimeMillis();
//        Object o = obj.removeKdigits("1432219", 3);
        Object o = obj.removeKdigits("112", 1);
//        Object o = obj.removeKdigits("10200", 1);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}