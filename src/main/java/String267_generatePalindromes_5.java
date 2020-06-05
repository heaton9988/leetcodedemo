import java.util.ArrayList;
import java.util.List;

public class String267_generatePalindromes_5 {
    public List<String> generatePalindromes(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() == 0) return ret;
        //统计字符频数
        char[] chars = s.toCharArray();
        int[] charCount = new int[256];
        for (char c : chars) charCount[c]++;
        //验证是否合法，顺便初始化回文字符串
        int oddCount = 0, len = chars.length;
        char[] buffer = new char[len];
        for (int i = 0; i < charCount.length; i++) {
            int cnt = charCount[i];
            if ((cnt & 1) == 1) {
                oddCount++;
                buffer[len / 2] = (char) i;//如果有，必然要放中间
            }
        }
        if (oddCount > 1) return ret;
        //生成所有可能的字符串
        dfs(ret, buffer, charCount, 0, len - 1);
        return ret;
    }

    private void dfs(List<String> ret, char[] buffer, int[] charCount, int left, int right) {
        if (left >= right) {
            ret.add(new String(buffer));
            return;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] < 2) continue;
            charCount[i] -= 2;
            buffer[left] = (char) i;
            buffer[right] = (char) i;
            dfs(ret, buffer, charCount, left + 1, right - 1);
            charCount[i] += 2;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String267_generatePalindromes_5().generatePalindromes("aab");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}