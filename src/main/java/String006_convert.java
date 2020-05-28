import java.util.ArrayList;
import java.util.List;

public class String006_convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int row = 0;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        char[] c = s.toCharArray();
        int n = c.length;
        boolean add = true;
        for (int i = 0; i < n; i++) {
            list.get(row).append(c[i]);
            if (add) {
                row++;
                if (row == numRows - 1) add = false;
            } else {
                row--;
                if (row == 0) add = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) res.append(sb.toString());
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        String006_convert obj = new String006_convert();
        long start = System.currentTimeMillis();
        Object o = obj.convert("LEETCODEISHIRING", 4);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}