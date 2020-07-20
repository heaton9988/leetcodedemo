public class Stack071_simplifyPath_array {
    String[] arr;
    int index = -1;

    public String simplifyPath(String path) {
        arr = new String[path.length()];
        char[] cs = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c == '/') {
                if (sb.length() > 0) {
                    process(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) process(sb.toString());
        sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append("/").append(arr[i]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    private void process(String s) {
        if (s.equals(".")) {
            return;
        } else if (s.equals("..")) {
            if (index >= 0) index--;
        } else {
            arr[++index] = s;
        }
    }

    public static void main(String[] args) {
        Stack071_simplifyPath_array obj = new Stack071_simplifyPath_array();
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