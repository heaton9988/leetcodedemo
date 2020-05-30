import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String247_findStrobogrammatic_3 {
    public char[][] keyCha = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        char[] matchedCha = new char[n];
        List<String> resList = new ArrayList<>();
        backTrace(matchedCha, 0, matchedCha.length - 1, resList);
        return resList;
    }

    public void backTrace(char[] matchedCha, int start, int end, List<String> res) {
        if (start > end) {
            if (matchedCha.length == 1 || matchedCha[0] != '0') { //当matchedCha中存的只是一位数，或者当开头不能为零的时候存入结果res中
                res.add(String.valueOf(matchedCha));
            }
            return; //当start>end时候就可以结束了
        }

        for (char[] c : keyCha) {
            if (start == end && c[0] != c[1]) { //当中间的数的时候只有00，11，88组合可以继续存入，其他的不可以，否则就会导致翻转的时候不一致
                continue;
            }
            matchedCha[start] = c[0];
            matchedCha[end] = c[1];
            backTrace(matchedCha, start + 1, end - 1, res);
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> list1 = new String247_findStrobogrammatic_3().findStrobogrammatic(3);
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