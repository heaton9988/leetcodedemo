import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        for (String banWord : banned) {
            bannedWords.add(banWord.toLowerCase());
        }

        HashMap<String, Integer> word2count = new HashMap<>();
        String ret = null;
        int max = 0;
        int start = 0;
        paragraph += " ";
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                String lowerWord = paragraph.substring(start, i).toLowerCase();
                if (!lowerWord.trim().equals("")) {
                    if (!bannedWords.contains(lowerWord)) {
                        word2count.put(lowerWord, 1 + word2count.getOrDefault(lowerWord, 0));
                        if (word2count.get(lowerWord) > max) {
                            max = word2count.get(lowerWord);
                            ret = lowerWord;
                        }
                    }
                }
                start = i + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String paragraph = "Bob";
        long start = System.currentTimeMillis();
        System.out.println(new MostCommonWords().mostCommonWord(paragraph, new String[]{"hit"}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}