public class Math067_addBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int l = a.length() - 1, r = b.length() - 1;
        int last = 0;
        while (l >= 0 || r >= 0) {
            int digita = l >= 0 ? a.charAt(l) - '0' : 0;
            int digitb = r >= 0 ? b.charAt(r) - '0' : 0;
            int sum = digita + digitb + last;
            res.append(sum % 2 == 0 ? 0 : 1);
            last = sum >= 2 ? 1 : 0;
            l--;
            r--;
        }
        if (last == 1) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math067_addBinary().addBinary("1011", "1010");

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}