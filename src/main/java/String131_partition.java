import java.util.ArrayList;
import java.util.List;

public class String131_partition {
    List<List<String>> res = new ArrayList<>();
    char[] cs;
    int n;
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        cs = s.toCharArray();
        n = cs.length;
        for (int i = 0; i < n; i++) {
            helper(0, i, new ArrayList<>());
        }
        return res;
    }

    private void helper(int start, int end, List<String> list) {
        if (isPalidrome(start, end)) {
            String added = s.substring(start, end + 1);
            list.add(added);
            if (end == n - 1) {
                res.add(list);
                return;
            }
            for (int i = end + 1; i < n; i++) {
                ArrayList<String> temp = new ArrayList<>(list);
                helper(end + 1, i, temp);
            }
        }
    }

    private boolean isPalidrome(int i, int j) {
        if (i > j) {
            throw new RuntimeException("error");
        }
        while (i < j) {
            if (cs[i++] != cs[j--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new String131_partition().partition("cdd");
//        Object o = new String131_partition().partition("aab");
        System.out.println(o);
    }
}