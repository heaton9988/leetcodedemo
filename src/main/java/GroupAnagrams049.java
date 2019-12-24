import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> target2words = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String target = new String(chars);
            List<String> words = target2words.get(target);
            if (words == null) {
                words = new ArrayList<>();
                target2words.put(target, words);
            }
            words.add(str);
        }
        return new ArrayList<>(target2words.values());
    }

    public static void main(String[] args) throws Exception {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams049 obj = new GroupAnagrams049();
        long start = System.currentTimeMillis();
        List<List<String>> lists = obj.groupAnagrams(strs);
        System.out.println(lists);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}