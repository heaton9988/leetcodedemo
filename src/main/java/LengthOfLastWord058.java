public class LengthOfLastWord058 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (right == 0 && c != ' ') {
                right = i;
                break;
            }
        }
        for (int i = right; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                return right - i;
            } else if (i == 0) return right - i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Object o = new LengthOfLastWord058().lengthOfLastWord("a     ");
        System.out.println(o);
    }
}