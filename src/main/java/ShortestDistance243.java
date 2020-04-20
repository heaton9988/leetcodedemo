public class ShortestDistance243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int i1 = -1, i2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            }
            if (words[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestDistance243 obj = new ShortestDistance243();
        long start = System.currentTimeMillis();

        Object v = obj.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}