public class String013_romanToInt {
    public int romanToInt(String s) {
        char c[] = s.toCharArray();
        int n = c.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                if (c[i] == 'I' && (c[i + 1] == 'V' || c[i + 1] == 'X')) {
                    res -= 1;
                } else if (c[i] == 'X' && (c[i + 1] == 'L' || c[i + 1] == 'C')) {
                    res -= 10;
                } else if (c[i] == 'C' && (c[i + 1] == 'D' || c[i + 1] == 'M')) {
                    res -= 100;
                } else {
                    res += getValue(c[i]);
                }
            } else {
                res += getValue(c[i]);
            }
        }
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String013_romanToInt().romanToInt("MCMXCIV");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}