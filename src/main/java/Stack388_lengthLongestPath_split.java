public class Stack388_lengthLongestPath_split {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t就是第一层）
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Stack388_lengthLongestPath_split obj = new Stack388_lengthLongestPath_split();
        long start = System.currentTimeMillis();
        Object o = obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
//        Object o = obj.lengthLongestPath("a");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}