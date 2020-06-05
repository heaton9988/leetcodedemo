import java.util.*;

public class String267_generatePalindromes {
    HashSet<String> resSet = new HashSet<>();
    List<Character> clist = new ArrayList<>();
    Character odd = null;

    public List<String> generatePalindromes(String s) {
        char[] cs = s.toCharArray();
        LinkedHashMap<Character, Integer> char2count = new LinkedHashMap<>();
        for (char c : cs) {
            char2count.put(c, char2count.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : char2count.entrySet()) {
            Character key = entry.getKey();
            Integer i = entry.getValue();
            if (i % 2 != 0) {
                if (odd != null && !key.equals(odd)) {
                    return new ArrayList<>(); // 至少有两个奇数, 则不能组成回文, 直接返回空list
                } else {
                    odd = key;
                    for (int x = 0; x < i / 2; x++) clist.add(key);
                }
            } else {
                for (int x = 0; x < i / 2; x++) clist.add(key);
            }
        }
        helper(new ArrayList<>(), new HashSet<>());
        return new ArrayList<>(resSet);
    }

    private void helper(List<Character> tempList, HashSet<Integer> excludeIndexes) {
        if (clist.size() == excludeIndexes.size()) {
            int tempSize = tempList.size();
            int size = 2 * tempSize + (odd == null ? 0 : 1);
            char[] c = new char[size];
            if (odd != null) {
                c[tempSize] = odd;
            }
            for (int i = 0; i < tempSize; i++) {
                c[i] = tempList.get(i);
                c[size - 1 - i] = tempList.get(i);
            }
            resSet.add(new String(c));
            return;
        }
        for (int i = 0; i < clist.size(); i++) {
            if (excludeIndexes.contains(i)) continue; // 只有第一次进来才是empty
            Character tempC = clist.get(i);
            tempList.add(tempC);
            excludeIndexes.add(i);
            for (int j = 0; j < clist.size(); j++) {
                helper(tempList, excludeIndexes);
            }
            excludeIndexes.remove(i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String267_generatePalindromes().generatePalindromes("aabbhijkkjih");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}