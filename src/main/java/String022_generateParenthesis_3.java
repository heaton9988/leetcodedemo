import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class String022_generateParenthesis_3 {
    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generate(c))
                    for (String right : generate(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String022_generateParenthesis_3().generateParenthesis(8);
        System.out.println(o);
        System.out.println(((List<String>) o).size());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}