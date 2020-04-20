import java.util.ArrayList;
import java.util.List;

public class YangHuiSanJiao118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        if (numRows >= 1) {
            ArrayList<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            resList.add(firstRow);
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = resList.get(i - 1);
            resList.add(curr);
            curr.add(1);
            for (int j = 1; j <= i; j++) {
                int val = prev.get(j - 1);
                if (j < i) val += prev.get(j);
                curr.add(val);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        YangHuiSanJiao118 obj = new YangHuiSanJiao118();
        long start = System.currentTimeMillis();

        Object v = obj.generate(7);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}