import java.util.*;

public class String247_findStrobogrammatic_2 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n > 2) {
            List<String> n2 = helper(n - 2);
            for (String shor : n2) {
                res.add("1" + shor + "1");
                res.add("6" + shor + "9");
                res.add("9" + shor + "6");
                res.add("8" + shor + "8");
            }
            return res;
        } else if (n == 1) {
            return Arrays.asList("0", "1", "8");
        } else if (n == 2) {
            return Arrays.asList("11", "88", "69", "96");
        }
        return res;
    }

    private List<String> helper(int n) {
        if (n > 2) {
            List<String> curr = new ArrayList<>();
            List<String> n_2 = helper(n - 2);
            for (String shor : n_2) {
                curr.add("0" + shor + "0");
                curr.add("1" + shor + "1");
                curr.add("6" + shor + "9");
                curr.add("9" + shor + "6");
                curr.add("8" + shor + "8");
            }
            return curr;
        } else if (n == 1) {
            return Arrays.asList("0", "1", "8");
        } else if (n == 2) {
            return Arrays.asList("00", "11", "88", "69", "96");
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> list1 = new String247_findStrobogrammatic_2().findStrobogrammatic(4);
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