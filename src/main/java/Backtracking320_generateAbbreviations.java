import java.util.ArrayList;
import java.util.List;

public class Backtracking320_generateAbbreviations {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        char[] cs = word.toCharArray();
        int len = cs.length;
        int len2 = (int) Math.pow(2, len);
        int[] pow2 = new int[len];
        for (int j = 1; j <= len; j++) {
            pow2[j - 1] = (int) Math.pow(2, len - j);
        }
        for (int i = 0; i < len2; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < pow2.length; j++) {
                int result = i & pow2[j];
                if (result > 0) {
                    if (count > 0) sb.append(count);
                    sb.append(cs[j]);
                    count = 0;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking320_generateAbbreviations().generateAbbreviations("yes");
//        Object o = new Backtracking320_generateAbbreviations().generateAbbreviations("a");
//        Object o = new Backtracking320_generateAbbreviations().generateAbbreviations("word");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}