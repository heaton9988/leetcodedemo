public class String065_isNumber_2 {
    public boolean isNumber(String s) {
        boolean seenNum = false;
        boolean seenDot = false;
        boolean seenE = false;
        char c[] = s.trim().toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                seenNum = true;
            } else if (c[i] == 'E' || c[i] == 'e') {
                if (seenE || !seenNum) return false;
                seenE = true;
                seenNum = false;
            } else if (c[i] == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else if (c[i] == '+' || c[i] == '-') {
                if (i != 0 && c[i] != 'e' && c[i] != 'E') return false;
            } else {
                return false;
            }
        }
        return seenNum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new String065_isNumber_2().isNumber(".1");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}