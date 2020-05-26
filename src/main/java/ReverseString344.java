public class ReverseString344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i <= n / 2; i++) {
            int j = n - 1 - i;
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"A"," ","m","a","n",","," ","a"," ","p","l","a","n",","," ","a"," ","c","a","n","a","l",":"," ","P","a","n","a","m","a"};
        char[] c = new char[s.length];
        for(int i=0;i<c.length;i++){
            c[i] = s[i].toCharArray()[0];
        }
        new ReverseString344().reverseString(new char[]{'h', 'e', 'l', 'l', 'o','a'});
//        new ReverseString344().reverseString(c);
    }
}