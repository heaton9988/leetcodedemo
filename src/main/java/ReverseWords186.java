public class ReverseWords186 {
    public void reverseWords(char[] s) {
        String origin = new String(s);
        String[] ss = origin.split(" ");
        int data = 0;
        for (int i = ss.length - 1; i >= 0; i--) {
            for (char c : ss[i].toCharArray()) {
                s[data++] = c;
            }
            if (data != s.length) {
                s[data++] = ' ';
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        new ReverseWords151().reverseWords(" aa    good   example  ");
        new ReverseWords186().reverseWords(new char[]{'a', 'b', ' ', 'c', 'd', ' ', 'e'});
    }
}