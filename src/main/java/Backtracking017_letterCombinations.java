import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backtracking017_letterCombinations {
    Map<Character, char[]> map = new HashMap<>();

    {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    List<String> res = new ArrayList<>();
    int len;
    char[][] css;

    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        len = digits.length();
        if (len == 0) return res;
        css = new char[len][];
        for (int i = 0; i < len; i++) {
            css[i] = map.get(cs[i]);
        }
        dfs(0, new StringBuilder());
        return res;
    }

    private void dfs(int startI, StringBuilder sb) {
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        for (int j = 0; j < css[startI].length; j++) {
            sb.append(css[startI][j]);
            dfs(startI + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking017_letterCombinations().letterCombinations("23");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}