public class String168_convertToTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int origin = n - 1;
        while (true) {
            int curr = origin % 26;
            sb.append((char) ('A' + curr));

            int next = origin / 26;
            if (next == 0) break;
            origin = next - 1;
        }
        StringBuilder res = sb.reverse();
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        String168_convertToTitle obj = new String168_convertToTitle();
        long start = System.currentTimeMillis();
        Object o = new String168_convertToTitle().convertToTitle(26*26);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}