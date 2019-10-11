import java.util.ArrayList;
import java.util.TreeMap;

public class ReorderLogFiles937 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return new String[]{};
        int len = logs.length;

        TreeMap<String, String> map = new TreeMap<>();
        ArrayList<String> digits = new ArrayList<>(len);
        for (String log : logs) {
            String[] split = log.split(" ", 2);
            char first = split[1].charAt(0);
            if (first <= '9' && first >= '0') {
                digits.add(log);
            } else {
                map.put(split[1] + split[0], log);
            }
        }
        String[] ret = new String[len];
        int index = 0;
        for (String v : map.values()) {
            ret[index++] = v;
        }
        for (String v : digits) {
            ret[index++] = v;
        }
        return ret;
    }

    public static void main(String[] args) {
        ReorderLogFiles937 obj = new ReorderLogFiles937();
        long start = System.currentTimeMillis();
        System.out.println(obj.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}