public class Math008_myAtoi {
    public int myAtoi(String str) {
        int res = 0;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) return res;

        int sign = 1;
        if (str.charAt(index) == '-') {
            sign = -1;
        } else if (str.charAt(index) == '+') {
            sign = 1;
        } else if (!isDigit(str.charAt(index))) {
            return res;
        } else {
            res = res * 10 + (str.charAt(index) - '0');
        }
        index++;

        while (index < str.length()) {
            char c = str.charAt(index);
            if (isDigit(c)) {
                int digit = c - '0';
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
            } else {
                break;
            }
            index++;
        }
        return sign * res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math008_myAtoi().myAtoi("   -42");
//        Object o = new Math008_myAtoi().myAtoi("4193 with words");
//        Object o = new Math008_myAtoi().myAtoi("words and 987"); // 0
//        Object o = new Math008_myAtoi().myAtoi("-91283472332"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("9223372036854775808"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("2147483648"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("-5-"); // -5

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}