import java.util.ArrayList;
import java.util.List;

public class Backtracking320_generateAbbreviations_dfs {
    List<String> res = new ArrayList<>();
    char[] cs;
    int len;

    public List<String> generateAbbreviations(String word) {
        cs = word.toCharArray();
        len = cs.length;
        if (len == 0) {
            res.add("");
            return res;
        }
        helper(0, 0, new StringBuilder());
        return res;
    }

    private void helper(int index, int count, StringBuilder sb) {
        int sbLen = sb.length();
        if (index == len) {
            if (count > 0) sb.append(count);
            res.add(sb.toString());
        } else {
            helper(index + 1, count + 1, sb);

            if (count > 0) sb.append(count);
            sb.append(cs[index]);
            helper(index + 1, 0, sb);
        }
        sb.setLength(sbLen);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking320_generateAbbreviations_dfs().generateAbbreviations("yes");
//        Object o = new Backtracking320_generateAbbreviations_dfs().generateAbbreviations("a");
//        Object o = new Backtracking320_generateAbbreviations_dfs().generateAbbreviations("word");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}