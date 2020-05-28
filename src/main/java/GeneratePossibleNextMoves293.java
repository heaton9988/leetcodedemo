import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleNextMoves293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) != '+') {
                i++;
            } else if (s.charAt(i) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new GeneratePossibleNextMoves293().generatePossibleNextMoves("--+++-+---+--");
        System.out.println(o);
    }
}