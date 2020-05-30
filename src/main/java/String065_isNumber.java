public class String065_isNumber {
    public boolean isNumber(String s) {
        char[] c = s.trim().toCharArray();
        int n = c.length;
        if (n == 0) return false;
        int limitE = 1;
        int limitSign = 1;
        int status = 0; // 0 init 1.leftDigitEnter 2. dot 3. rightDigitEnter  4. e   5  digit
        for (int i = 0; i < n; i++) {
            if (c[i] >= '0' && c[i] < '9') {
                if (status == 0) status = 1;
                else if (status == 2) status = 3;
                else if (status == 4) status = 5;
            } else if (c[i] == '.') {
                if (status == 0 || status == 1) status = 2;
                else if (status >= 2) return false;
            } else if (c[i] == ' ') {
                return false;
            } else if (c[i] == 'e') {
                if (status < 1) return false;
                limitE--;
                if (limitE < 0) return false;
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                return false;
            } else if (c[i] == '-' || c[i] == '+') { // done
                if (i != 0) return false;
                limitSign--;
                if (limitSign < 0) return false;
            }
        }
        if (status==2)return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String065_isNumber().isNumber(".1");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}