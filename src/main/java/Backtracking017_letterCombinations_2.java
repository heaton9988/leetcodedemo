import java.util.ArrayList;
import java.util.List;

public class Backtracking017_letterCombinations_2 {
    List<String> res = new ArrayList<>();
    int len;
    char[][] map = new char[][]{
            new char[]{'a', 'b', 'c'}
            , new char[]{'d', 'e', 'f'}
            , new char[]{'g', 'h', 'i'}
            , new char[]{'j', 'k', 'l'}
            , new char[]{'m', 'n', 'o'}
            , new char[]{'p', 'q', 'r', 's'}
            , new char[]{'t', 'u', 'v'}
            , new char[]{'w', 'x', 'y', 'z'}
    };
    char[][] css;

    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        len = digits.length();
        if (len == 0) return res;
        css = new char[len][];
        for (int i = 0; i < len; i++) {
            css[i] = map[cs[i] - '2'];
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
        Object o = new Backtracking017_letterCombinations_2().letterCombinations("23");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}