import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] input = new String[]{"wooooow"};
        for (String old : input) {
            int left = 2;
            char[] cs = old.toCharArray();
            for (int right = 2; right < cs.length; right++) {
                HashMap<Character, Integer> map = new HashMap<>();
                map.put(cs[right], 1);
                boolean write = true;
                for (int i = left - 1; i >= 0 && i >= left - 3; i--) {
                    int count = map.getOrDefault(cs[i], 0);
                    count++;
                    map.put(cs[i], count);
                    if (count >= 3) {
                        write = false;
                        break; // 等待right++, 执行下一个循环
                    } else if (count == 2) {
                        if (map.size() == 2) {
                            Iterator<Integer> it = map.values().iterator();
                            int c1 = it.next(), c2 = it.next();
                            if (c1 == 2 && c2 == 2 && cs[right] == cs[left-1]) {
                                write = false;
                                break;
                            }
                        }
                    }
                }
                if (write) {
                    cs[left++] = cs[right];
                }
            }
            System.out.println(new String(cs, 0, left));
        }
    }
}