import java.util.Stack;

public class Stack071_simplifyPath {
    Stack<String> stack = new Stack<>();

    public String simplifyPath(String path) {
        int fromIndex = 0;
        while (true) {
            String s = null;
            if (fromIndex >= path.length()) break;
            int nextSlash = path.indexOf("/", fromIndex);
            if (nextSlash == -1) {
                s = path.substring(fromIndex);
                process(s);
                break;
            } else if (fromIndex == nextSlash) {
                fromIndex++;
            } else {
                s = path.substring(fromIndex, nextSlash);
                process(s);
                fromIndex = nextSlash + 1;
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            String top = stack.pop();
            res = "/" + top + res;
        }
        return res == "" ? "/" : res;
    }

    private void process(String s) {
        if (s.equals(".")) {
            return;
        } else if (s.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else {
            stack.push(s);
        }
    }

    public static void main(String[] args) {
        Stack071_simplifyPath obj = new Stack071_simplifyPath();
        long start = System.currentTimeMillis();
        String old = "/home//foo/";
        old = "/home/";
        old = "/../";
        old = "/a/./b/../../c/";
        old = "/a/../../b/../c//.//";
        old = "/a//b////c/d//././/..";
        Object o = obj.simplifyPath(old);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}