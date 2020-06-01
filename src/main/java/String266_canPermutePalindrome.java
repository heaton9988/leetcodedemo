public class String266_canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        char[] cs = s.toCharArray();
        int[] count = new int[128];
        for (char c : cs) {
            count[c]++;
        }
        int countSingle = 0;
        for (int c : count) {
            if (c % 2 != 0) {
                countSingle++;
            }
        }
        if (countSingle <= 1) return true;
        return false;
    }

    public static void main(String[] args) {
        Object o = new String266_canPermutePalindrome().canPermutePalindrome("carerac");
        System.out.println(o);
    }
}