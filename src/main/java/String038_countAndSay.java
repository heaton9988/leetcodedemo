public class String038_countAndSay {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) return res;
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            char last = res.charAt(0);
            int L = res.length();
            int count = 1;
            for (int j = 1; j < L; j++) {
                char curr = res.charAt(j);
                if (curr != last) {
                    sb.append(count).append(last);
                    last = curr;
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(last);
            res = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String038_countAndSay obj = new String038_countAndSay();
        long start = System.currentTimeMillis();
        Object o = obj.countAndSay(10);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}