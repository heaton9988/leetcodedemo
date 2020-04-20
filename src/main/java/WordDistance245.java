public class WordDistance245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int i1 = -1, i2 = -1;
        boolean same = word1.equals(word2);
        boolean isI1 = true;
        for (int i = 0; i < words.length; i++) {
            if (same) {
                if (words[i].equals(word1)) {
                    if (isI1) i1 = i;
                    else i2 = i;
                    isI1 = !isI1;
                }
            } else {
                if (words[i].equals(word1)) {
                    i1 = i;
                }
                if (words[i].equals(word2)) {
                    i2 = i;
                }
            }

            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordDistance245 obj = new WordDistance245();
        long start = System.currentTimeMillis();

        Object v = obj.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes");
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}