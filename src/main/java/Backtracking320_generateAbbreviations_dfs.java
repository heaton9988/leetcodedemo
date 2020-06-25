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
        helper(1, 0, "" + cs[0]);
        helper(1, 1, "");
        return res;
    }

    private void helper(int index, int count, String sb) {
        if (index == len) {
            if (count > 0) {
                res.add(sb + count);
            } else {
                res.add(sb);
            }
            return;
        }
        helper(index + 1, count + 1, sb);

        helper(index + 1, 0, count > 0 ? sb + count + cs[index] : sb + cs[index]);
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