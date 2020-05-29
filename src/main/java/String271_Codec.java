import java.util.ArrayList;
import java.util.List;

public class String271_Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return null;
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s).append('\u0000');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null) return res;

        char[] cs = s.toCharArray();
        int lastIndex = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '\u0000') {
                res.add(s.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String271_Codec obj = new String271_Codec();
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        String s = obj.encode(list);
        List<String> list2 = obj.decode(s);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}