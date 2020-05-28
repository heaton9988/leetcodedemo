import java.util.*;

public class String179_largestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int num : nums) list.add(num + "");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder s1 = new StringBuilder(o2);
                s1.append(o1);
                StringBuilder s2 = new StringBuilder(o1);
                s1.append(o2);
                return s1.toString().compareTo(s2.toString());
            }
        });
        for (String s : list) sb.append(s);
        if (list.get(0).equals("0")) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String179_largestNumber obj = new String179_largestNumber();
        long start = System.currentTimeMillis();
//        Object o = obj.largestNumber(new int[]{3, 30, 34, 5, 9});
        Object o = obj.largestNumber(new int[]{0, 0});
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}