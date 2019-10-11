public class LongestPalindrome4 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            i = findrange(a, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findrange(char[] a, int low, int[] range) {
        int high = low;
        while (high < a.length - 1 && a[high + 1] == a[low]) {
            high++;
        }
        int mid = high;
        while (low > 0 && high < a.length - 1 && a[low - 1] == a[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return mid;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4000; i++) {
            sb.append("a");
        }
        String s = sb.toString();

        s = "abcba";

        long start = System.currentTimeMillis();
        String result = new LongestPalindrome4().longestPalindrome(s);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}