public class StrStr28 {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2 = needle.length();
        if (n2 == 0) return 0;
        for (int i = 0; i <= n1 - n2; i++) {
            boolean match = true;
            for (int j = 0; j < n2; j++) {
                char c1 = haystack.charAt(i + j);
                char c2 = needle.charAt(j);
                if (c1 != c2) {
                    match = false;
                    break;
                }
            }
            if (match) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = new StrStr28().strStr("hello", "lld");
        System.out.println(result);
    }
}