import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopologicalSort269_alienOrder {
    HashMap<Character, List<Character>> startRules = new HashMap();
    HashMap<Character, List<Character>> endRules = new HashMap();
    boolean hasError = false;

    public String alienOrder(String[] words) {
        check(Arrays.asList(words));
        while (startRules.size() > 1) {
            Character endOfFirstList = null;
            Character endOfSecondList = null;
            List<Character> firstList = null;
            Character removeSingleLetter = null;
            boolean find = false;
            for (char first : startRules.keySet()) {
                firstList = startRules.get(first);
                endOfFirstList = firstList.get(firstList.size() - 1);
                List<Character> secondList = startRules.get(endOfFirstList);
                if (secondList != null) {
                    if (secondList.size() > 1) {
                        find = true;
                        for (int i = 1; i < secondList.size(); i++) {
                            firstList.add(secondList.get(i));
                        }
                        endOfSecondList = secondList.get(secondList.size() - 1);
                        break;
                    } else {
                        char singleLetter = secondList.get(0);
                        if (startRules.containsKey(singleLetter) || endRules.containsKey(singleLetter)) {
                            find = true;
                            removeSingleLetter = singleLetter;
                        }
                    }

                }
            }
            if (find) {
                if (removeSingleLetter != null) {
                    endRules.remove(removeSingleLetter);
                    startRules.remove(removeSingleLetter);
                }
                endRules.put(endOfSecondList, firstList);
                endRules.remove(endOfFirstList);
                startRules.remove(endOfFirstList);
            } else {
                break;
            }
        }
        if (hasError) return "";

        StringBuilder sb = new StringBuilder();
        for (List<Character> list : startRules.values()) {
            for (char c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void check(List<String> list) {
        if (hasError) return;
        if (list == null || list.size() == 0) return;
        List<List<String>> split = new ArrayList<>();
        List<Character> firstLetters = new ArrayList<>();
        Character lastFirstLetter = null;
        for (String word : list) {
            if (lastFirstLetter == null) {
                lastFirstLetter = word.charAt(0);
                firstLetters.add(lastFirstLetter);
                split.add(new ArrayList<>());
            } else if (lastFirstLetter.equals(word.charAt(0))) {
            } else {
                lastFirstLetter = word.charAt(0);
                if (firstLetters.contains(lastFirstLetter)) {
                    hasError = true;
                    return;
                }
                firstLetters.add(lastFirstLetter);
                split.add(new ArrayList<>());
            }
            if (word.length() > 1) {
                split.get(split.size() - 1).add(word.substring(1));
            }
        }
        if (firstLetters.size() > 0) {
            if (!startRules.containsKey(firstLetters.get(0)) || startRules.get(firstLetters.get(0)).size() < firstLetters.size()) {
                startRules.put(firstLetters.get(0), firstLetters);
                endRules.put(firstLetters.get(firstLetters.size() - 1), firstLetters);
            }
        }
        for (int i = 0; i < split.size(); i++) {
            check(split.get(i));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TopologicalSort269_alienOrder obj = new TopologicalSort269_alienOrder();
//        System.out.println(obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
//        System.out.println(obj.alienOrder(new String[]{"z", "x","z"}));
//        System.out.println(obj.alienOrder(new String[]{"z", "z"}));
//        System.out.println(obj.alienOrder(new String[]{"zy", "zx"}));
        System.out.println(obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}