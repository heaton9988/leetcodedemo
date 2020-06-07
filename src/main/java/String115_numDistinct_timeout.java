import java.util.ArrayList;
import java.util.List;

public class String115_numDistinct_timeout {
    List<String> res = new ArrayList<>();

    public int numDistinct(String s, String t) {
        help(s, t, 0, 0, new ArrayList<>());
        return res.size();
    }

    private void help(String s, String t, int is, int it, List<Integer> temp) {
        if (temp.size() == t.length()) {
            res.add(temp.toString());
        } else if (is < s.length() && it < t.length()) {
            char cs = s.charAt(is);
            char ct = t.charAt(it);

            if (cs == ct) { // use
                temp.add(is);
                help(s, t, is + 1, it + 1, temp);
                temp.remove(temp.size() - 1);
            }
            help(s, t, is + 1, it, temp); // no use
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new String115_numDistinct().numDistinct("bagbbag", "bag");
        Object o = new String115_numDistinct_timeout().numDistinct("anacondastreetracecar", "contra");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}