import java.util.HashMap;
import java.util.Map;

public class CanWin294 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) != '+') {
                i++;
            } else if (s.charAt(i) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!canWin(sb.toString())) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        Object o = new CanWin294().canWin("--+++++-+---+--");
        System.out.println(o);
    }
}