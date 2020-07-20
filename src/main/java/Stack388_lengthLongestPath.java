public class Stack388_lengthLongestPath {
    char[] cs;
    String[] dir;
    int res = 0;

    public int lengthLongestPath(String input) {
        cs = input.toCharArray();
        dir = new String[input.length() / 2 + 1];
        StringBuilder sb = new StringBuilder();
        int countTab = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '\t') {
                if (cs[i] == '\n' || i == cs.length - 1) {
                    if (i == cs.length - 1) sb.append(cs[i]);
                    String fileName = sb.toString();
                    sb.setLength(0);
                    if (fileName.contains(".")) {
                        StringBuilder filePath = new StringBuilder();
                        for (int j = 0; j < countTab; j++) {
                            filePath.append(dir[j]).append("/");
                        }
                        filePath.append(fileName);
                        if (filePath.length() > res) res = filePath.length();
                    } else {
                        dir[countTab] = fileName;
                    }
                    countTab = 0;
                } else {
                    sb.append(cs[i]);
                }
            } else {
                countTab++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Stack388_lengthLongestPath obj = new Stack388_lengthLongestPath();
        long start = System.currentTimeMillis();
//        Object o = obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        Object o = obj.lengthLongestPath("a");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}