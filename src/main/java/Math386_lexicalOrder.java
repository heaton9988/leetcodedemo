import java.util.ArrayList;
import java.util.List;

public class Math386_lexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        help(1, 9, n, res);
        return res;
    }

    private void help(int start, int end, int n, List<Integer> res) {
        for (int i = start; i <= end && i <= n; i++) {
            res.add(i);
            help(i * 10, i * 10 + 9, n, res);
        }
    }

    public static void main(String[] args) {
        Object o = new Math386_lexicalOrder().lexicalOrder(223);
        for (Integer num : (List<Integer>) o) {
            System.out.println(num);
        }
    }
}