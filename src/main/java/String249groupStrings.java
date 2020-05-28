import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String249groupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strings) {
            StringBuilder key = new StringBuilder();
            if (s.length() == 1) {
                key.append("single");
            } else {
                for (int i = 1; i < s.length(); i++) {
                    int diff = s.charAt(i) - s.charAt(i - 1);
                    if (diff < 0) diff += 26;
                    key.append(diff).append(",");
                }
            }
            List<String> list = map.get(key.toString());
            if (list == null) {
                list = new ArrayList<>();
                map.put(key.toString(), list);
            }
            list.add(s);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String[] strs = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        String249groupStrings obj = new String249groupStrings();
        long start = System.currentTimeMillis();
        List<List<String>> lists = obj.groupStrings(strs);
        System.out.println(lists);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}