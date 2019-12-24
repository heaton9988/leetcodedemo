import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int start = 0, end = 0;
        while (true) {
            boolean endHasChanged = false;
            for (int i = start; i <= end; i++) {
                int lastIndexOf = S.lastIndexOf(S.charAt(i));
                if (lastIndexOf > end) {
                    end = lastIndexOf;
                    endHasChanged = true;
                    break;
                }
            }
            if (!endHasChanged) {
                String substring = S.substring(start, end + 1);
                ret.add(substring.length());
                if (end + 1 >= S.length()) {
                    break;
                }
                start = end + 1;
                end = end + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        PartitionLabels763 obj = new PartitionLabels763();
        long start = System.currentTimeMillis();
        List<Integer> result = obj.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}