import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backtracking093_restoreIpAddresses {
    List<String> res = new ArrayList<>();
    int len;
    char[] cs;
    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.cs = s.toCharArray();
        this.len = s.length();
        helper(0, 0, new ArrayList<Integer>());
        return res;
    }

    private void helper(int start, int count, ArrayList<Integer> list) {
        if (list.size() == 4 || count >= len) {
            if (list.size() == 4 && count == len) {
                StringBuilder sb = new StringBuilder();
                for (Integer num : list) {
                    sb.append(num).append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
            return;
        }

        for (int i = start + 1; i <= len && i <= start + 3; i++) {
            int remainCount = 4 - list.size();
            int remainChars = len - start;
            if (remainChars > remainCount * 3 || remainChars < remainCount) {
                return;
            }
            if (i - start > 1 && cs[start] == '0') break;
            String str = s.substring(start, i);
            int sum = Integer.parseInt(str);
            if (sum > 255) {
                break;
            }
            list.add(sum);
            helper(i, count + i - start, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new Backtracking093_restoreIpAddresses().restoreIpAddresses("25525511135");
        Object o = new Backtracking093_restoreIpAddresses().restoreIpAddresses("010010");
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}