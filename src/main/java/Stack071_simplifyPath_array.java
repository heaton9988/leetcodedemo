public class Stack071_simplifyPath_array {
    String[] arr;
    int index = -1;

    public String simplifyPath(String path) {
        arr = new String[path.length()];
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
        StringBuilder sb = new StringBuilder();
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