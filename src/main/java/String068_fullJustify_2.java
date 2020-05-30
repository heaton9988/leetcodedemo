import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String068_fullJustify_2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int cur = index, len = 0;
            // len + words[cur].length() + cur - index 为单词之间取 一个空格的长度
            while (cur < words.length && len + words[cur].length() + cur - index <= maxWidth) {
                // 计算纯单词长度
                len = len + words[cur++].length();
            }
            cur--;
            // System.out.println(cur + " " + len);
            StringBuilder sb = new StringBuilder();
            // 区分最后一行
            if (cur == words.length - 1) {
                for (int i = index; i <= cur; i++) {
                    sb.append(words[i]);
                    if (i < cur) {
                        sb.append(' ');
                    }
                }
            } else {
                int base = cur > index ? (maxWidth - len) / (cur - index) : (maxWidth - len);
                String baseStr = genSpace(base);
                int left = cur > index ? (maxWidth - len) % (cur - index) : 0;
                String leftStr = genSpace(base + 1);
                for (int i = index; i <= cur; i++) {
                    sb.append(words[i]);
                    if (i < cur) {
                        sb.append(left > 0 ? leftStr : baseStr);
                        left--;
                    }
                }
            }
            if (sb.length() < maxWidth) {
                sb.append(genSpace(maxWidth - sb.length()));
            }
            ret.add(sb.toString());
            index = cur + 1;
        }
        return ret;
    }

    private String genSpace(int n) {
        char[] cs = new char[n];
        Arrays.fill(cs, ' ');
        return new String(cs);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String068_fullJustify_2().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
//        Object o = new String068_fullJustify().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}