public class String246_isStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        for (int i = 0; i <= n / 2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(n - 1 - i);
            if (c1 == '6') {
                if (c2 != '9') return false;
            } else if (c1 == '9') {
                if (c2 != '6') return false;
            } else if (c1 == '8') {
                if (c2 != '8') return false;
            } else if (c1 == '0') {
                if (c2 != '0') return false;
            } else if (c1 == '1') {
                if (c2 != '1') return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String246_isStrobogrammatic().isStrobogrammatic("6688899");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}