public class String125_isPalindrome {
    public boolean isPalindrome(String s) {
        char cs[] = s.toCharArray();
        int n = cs.length;
        if (n < 1) return true;
        int l = 0, r = n - 1;
        while (l <= r) {
            while (l <= r && !inRange(cs[l])) {
                l++;
            }
            while (l <= r && !inRange(cs[r])) {
                r--;
            }
            if (l > r) break;
            char left = toLower(cs[l]);
            char right = toLower(cs[r]);
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean inRange(char c) {
        return (c <= 'z' && c >= 'a') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }
        return c;
    }

    public static void main(String[] args) {
        Object o = new String125_isPalindrome().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(o);
    }
}