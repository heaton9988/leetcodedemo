import java.util.ArrayList;
import java.util.List;

public class ReverseWords151 {
    public String reverseWords(String s) {
        int n = s.length();
        List<Integer> indexs = new ArrayList<>();
        boolean findEnd = true;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (findEnd) {
                if (c == ' ') {
                    continue;
                } else {
                    indexs.add(i);
                    findEnd = false;
                }
            } else {
                if (c == ' ') {
                    indexs.add(i);
                    findEnd = true;
                } else {
                    continue;
                }
            }
        }
        if (indexs.size() % 2 != 0) {
            indexs.add(-1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexs.size() / 2; i++) {
            sb.append(s.substring(indexs.get(i * 2 + 1) + 1, indexs.get(i * 2) + 1)).append(" ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        new ReverseWords151().reverseWords(" aa    good   example  ");
        new ReverseWords151().reverseWords("");
    }
}