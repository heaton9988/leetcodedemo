import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] counts = new int[256];
        LinkedHashMap<Character, Integer> char2index = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!char2index.containsKey(c)) {
                char2index.put(c, i);
            }
            counts[c]++;
        }
        int res = -1;
        for (Map.Entry<Character, Integer> entry : char2index.entrySet()) {
            Character key = entry.getKey();
            if (counts[key] == 1) {
                return entry.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new FirstUniqChar387().firstUniqChar("loveleetcode");
        System.out.println(o);
    }
}