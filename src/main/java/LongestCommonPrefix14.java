public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        String res = strs[0];
        for (int i = 1; i < n; i++) {
            while (!strs[i].startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};
        Object o = new LongestCommonPrefix14().longestCommonPrefix(arr);
        System.out.println(o);
    }
}