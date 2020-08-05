import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Design288_ValidWordAbbr {
    private Map<String, Set<String>> abbrBook;

    public Design288_ValidWordAbbr(String[] dictionary) {
        abbrBook = new HashMap<>();
        for (String word : dictionary) {
            String abbr = abbr(word);
            abbrBook.computeIfAbsent(abbr, key -> new HashSet<>()).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbr(word);
        Set<String> sameAbbr = abbrBook.get(abbr);
        if (sameAbbr == null) {
            return true;
        } else {
            return sameAbbr.contains(word) && sameAbbr.size() == 1;
        }
    }

    public String abbr(String word) {
        String abbr;
        if (word.length() < 2) {
            abbr = word;
        } else {
            abbr = new StringBuilder()
                    .append(word.charAt(0))
                    .append((word.length() - 2))
                    .append(word.charAt(word.length() - 1))
                    .toString();
        }
        return abbr;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design288_ValidWordAbbr obj = new Design288_ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(obj.isUnique("dear"));
        System.out.println(obj.isUnique("cart"));
        System.out.println(obj.isUnique("cane"));
        System.out.println(obj.isUnique("make"));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}