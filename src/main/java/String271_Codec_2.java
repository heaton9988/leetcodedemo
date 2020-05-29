import java.util.ArrayList;
import java.util.List;

public class String271_Codec_2 {
    // Encodes string length to bytes string
    public String intToString(String s) {
        int x = s.length();
        char[] bytes = new char[4];
        for (int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(intToString(s));
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for (char b : bytesStr.toCharArray())
            result = (result << 8) + (int) b;
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> output = new ArrayList();
        while (i < n) {
            int length = stringToInt(s.substring(i, i + 4));
            i += 4;
            output.add(s.substring(i, i + length));
            i += length;
        }
        return output;
    }

    public static void main(String[] args) throws Exception {
        String271_Codec_2 obj = new String271_Codec_2();
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("");
        list.add("b");
        String s = obj.encode(list);
        List<String> list2 = obj.decode(s);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}