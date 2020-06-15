import java.util.*;

public class Math357_countNumbersWithUniqueDigits {
    int res = 0;
//    List<Integer> resList = new ArrayList<>();

    public int countNumbersWithUniqueDigits(int n) {
        int max = (int) Math.pow(10, n);
        LinkedHashSet<Integer> list = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) list.add(i);
        for (int i = 1; i < 10; i++) {
            list.remove(i);
            help(list, i, max, 0);
            list.add(i);
        }
//        Collections.sort(resList);
//        System.out.println(resList);
        return res + 1;
    }

    private void help(LinkedHashSet<Integer> list, int currDigit, int n, int preSum) {
        int currSum = preSum * 10 + currDigit;
        if (currSum >= n) {
            return;
        } else {
            res++;
//            resList.add(currSum);
        }
        for (int index = 0; index < list.size(); index++) {
            int nextDigit = list.iterator().next();
            list.remove(nextDigit);
            help(list, nextDigit, n, currSum);
            list.add(nextDigit);
        }
    }

    public static void main(String[] args) {
        Object o = new Math357_countNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2);
        System.out.println(o);
    }
}