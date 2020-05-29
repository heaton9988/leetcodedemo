import java.util.*;

public class String247_findStrobogrammatic {
    HashMap<Character, Character> map = new HashMap<>();
    int n;
    int middle;

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        this.n = n;
        this.middle = (n + 1) / 2;
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (entry.getKey().equals('0')) continue;
            helper(entry.getValue().toString(), res);
        }
        return res;
    }

    private void helper(String curr, List<String> res) {
        if (curr.length() == this.middle) {
            res.add(fill(curr));
            return;
        }
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (n % 2 != 0 && curr.length() == this.middle - 1 && (entry.getKey().equals('6') || entry.getKey().equals('9')))
                continue;
            helper(curr + entry.getValue().toString(), res);
        }
    }

    private String fill(String origin) {
        char[] res = new char[n];
        char[] o = origin.toCharArray();
        for (int i = 0; i < o.length; i++) {
            res[i] = o[i];
            res[n - 1 - i] = map.get(o[i]);
        }
        return new String(res);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> list1 = new String247_findStrobogrammatic().findStrobogrammatic(5);
        System.out.println(list1);
        List<String> list2 = Arrays.asList("10001", "10101", "10801", "11011", "11111", "11811", "16091", "16191", "16891", "18081", "18181", "18881", "19061", "19161", "19861", "60009", "60109", "60809", "61019", "61119", "61819", "66099", "66199", "66899", "68089", "68189", "68889", "69069", "69169", "69869", "80008", "80108", "80808", "81018", "81118", "81818", "86098", "86198", "86898", "88088", "88188", "88888", "89068", "89168", "89868", "90006", "90106", "90806", "91016", "91116", "91816", "96096", "96196", "96896", "98086", "98186", "98886", "99066", "99166", "99866");
        for (String s : list2) {
            if (!list1.contains(s)) {
                System.out.println(s);
            }
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}