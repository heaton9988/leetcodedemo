public class Bit389_findTheDifference {
    public char findTheDifference(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        if (len1 == 0) return cs2[0];

        char res = cs1[0];
        for (int i = 1; i < cs1.length; i++) {
            res ^= cs1[i];
        }
        for (char c : cs2) {
            res ^= c;
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Bit389_findTheDifference obj = new Bit389_findTheDifference();
        System.out.println(obj.findTheDifference("abcd", "abcde"));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}