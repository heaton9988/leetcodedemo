import java.util.*;

public class String267_generatePalindromes_4 {
    HashSet<String> res = new HashSet<>();
    Character odd = null;

    public List<String> generatePalindromes(String s) {
        List<Character> clist = new ArrayList<>();
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
        helper(clist.toArray(new Character[0]), 0);
        return new ArrayList<>(res);
    }

    private void helper(Character[] cs, int start) {
        if (start == cs.length) {
            int tempSize = cs.length;
            int size = 2 * tempSize + (odd == null ? 0 : 1);
            char[] c = new char[size];
            if (odd != null) {
                c[tempSize] = odd;
            }
            for (int i = 0; i < tempSize; i++) {
                c[i] = cs[i];
                c[size - 1 - i] = cs[i];
            }
            res.add(new String(c));
            return;
        }
        for (int i = start; i < cs.length; i++) {
            if (cs[i] != cs[start] || i == start) {
                swap(cs, i, start);
                helper(cs, start + 1);
                swap(cs, i, start);
            }
        }
    }

    private void swap(Character[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String267_generatePalindromes_4().generatePalindromes("aabbc");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}