import java.util.ArrayList;
import java.util.List;

public class String131_partition_3 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] strArr = s.toCharArray();
        List<String> current = new ArrayList<>();
        getAll(result, current, strArr, 0);
        return result;
    }

    private void getAll(List<List<String>> result, List<String> current, char[] strArr, int idx) {
        if (idx == strArr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < strArr.length; i++) {
            if (isPalindromre(strArr, idx, i)) {
                current.add(String.valueOf(strArr, idx, i - idx + 1));
                getAll(result, current, strArr, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindromre(char[] strArr, int left, int right) {
        while (left <= right) {
            if (strArr[left++] != strArr[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new String131_partition_3().partition("aab");
        System.out.println(o);
    }
}