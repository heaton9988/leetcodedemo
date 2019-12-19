import java.util.HashSet;

public class MinimumWindowSubstring076_fail {
    public String minWindow(String s, String t) {
        String ret = "";
        if (s.length() < t.length()) {
            return ret;
        }
        int minLength = Integer.MAX_VALUE;
        HashSet<Character> targets = new HashSet<>();
        for (char c : t.toCharArray()) {
            targets.add(c);
        }

        for (int i = 0; i <= s.length() - targets.size(); i++) {
            HashSet<Character> count = new HashSet<>();
            if (!targets.contains(s.charAt(i))) continue;

            for (int j = i; j < s.length(); j++) {
                if (targets.contains(s.charAt(j))) {
                    count.add(s.charAt(j));
                }
                if (count.size() == targets.size()) {
                    int length = j - i + 1;
                    if (length < minLength) {
                        minLength = length;
                        ret = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        MinimumWindowSubstring076_fail obj = new MinimumWindowSubstring076_fail();
        long start = System.currentTimeMillis();
        String result = obj.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}