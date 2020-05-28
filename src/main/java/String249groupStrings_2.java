import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class String249groupStrings_2 {
    private String computeHash(String s) {
        if (s.length() == 0) return s;
        int offset = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((char) ((c - offset + 26) % 26));
        }
        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> cache = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();

        for (String s : strings) {
            String hash = computeHash(s);
            List<String> tmp = cache.getOrDefault(hash, new LinkedList<>());
            tmp.add(s);
            cache.put(hash, tmp);
        }

        for (List<String> vs : cache.values()) ans.add(vs);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        String[] strs = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        String249groupStrings_2 obj = new String249groupStrings_2();
        long start = System.currentTimeMillis();
        List<List<String>> lists = obj.groupStrings(strs);
        System.out.println(lists);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}