public class ReverseVowels345 {
    public String reverseVowels(String s) {
        int n = s.length();
        if (n <= 1) return s;
        int[] letter = new int[256];
        letter['a'] = 1;
        letter['e'] = 1;
        letter['i'] = 1;
        letter['o'] = 1;
        letter['u'] = 1;
        letter['A'] = 1;
        letter['E'] = 1;
        letter['I'] = 1;
        letter['O'] = 1;
        letter['U'] = 1;
        char[] cs = s.toCharArray();

        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && letter[cs[l]] == 0) {
                l++;
            }
            while (l < r && letter[cs[r]] == 0) {
                r--;
            }
            if (l < r) {
                char tmp = cs[l];
                cs[l] = cs[r];
                cs[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels345().reverseVowels("leetcode"));
    }
}