public class String009_isPalindrome {
    public boolean isPalindrome(int x) {
        int s = 0;
        int x1 = x;
        while (x1 > s) {
            s = s * 10 + x1 % 10;
            x1 = x1 / 10;
        }
        return s == x;
    }

    public static void main(String[] args) {
        Object o = new String009_isPalindrome().isPalindrome(12345);
        System.out.println(o);
    }
}