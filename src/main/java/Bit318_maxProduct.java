public class Bit318_maxProduct {

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] cache = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                cache[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((cache[i] & cache[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Bit318_maxProduct obj = new Bit318_maxProduct();
        System.out.println(obj.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}