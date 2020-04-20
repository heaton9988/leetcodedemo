import java.util.ArrayList;
import java.util.List;

public class YangHuiSanJiao119 {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<Integer> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            res.add(1);
            for (int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        YangHuiSanJiao119 obj = new YangHuiSanJiao119();
        long start = System.currentTimeMillis();

        Object v = obj.getRow(33);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}