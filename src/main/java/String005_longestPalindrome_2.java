public class String005_longestPalindrome_2 {
    int start = 0, end = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) return "";
        char[] charArr = s.toCharArray();
        helper(charArr, 0);
        return s.substring(start, end + 1);
    }

    private void helper(char[] cs, int index) {
        if (index >= cs.length - 1) {
            return;
        }
        int cur_start = index, cur_end = index;
        while (cur_end < cs.length - 1 && cs[cur_end + 1] == cs[cur_start]){
            cur_end++;
        }
        index = cur_end;
        while (cur_start > 0 && cur_end < cs.length - 1 && cs[cur_end + 1] == cs[cur_start - 1]) {
            cur_end++;
            cur_start--;
        }
        // 找到一个从cur_start到cur_end的
        if (cur_end - cur_start > end - start) {
            start = cur_start;
            end = cur_end;
        }
        helper(cs, index + 1);
    }

    public static void main(String[] args) {
//        Object o = new String005_longestPalindrome_2().longestPalindrome("babad");
        Object o = new String005_longestPalindrome_2().longestPalindrome("abbba");
        System.out.println(o);
    }
}