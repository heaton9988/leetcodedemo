public class Math008_myAtoi {
    public int myAtoi(String str) {
        boolean seenNum = false;
        boolean seenSign = false;
        int sign = 1;
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (seenNum || seenSign) break;
                continue;
            } else if (c == '-' || c == '+') {
                if (seenNum) {
                    return 0;
                }
                if (seenSign) {
                    break;
                }
                seenSign = true;
                if (c == '-') sign = -1;
            } else if (c >= '0' && c <= '9') {
                seenNum = true;
                int digit = c - '0';
                if (sum > (Integer.MAX_VALUE - digit) / 10) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                sum = sum * 10 + digit;
            } else {
                if (!seenNum) return 0;
                else break;
            }
        }
        return sign * sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new Math008_myAtoi().myAtoi("   -42");
//        Object o = new Math008_myAtoi().myAtoi("4193 with words");
//        Object o = new Math008_myAtoi().myAtoi("words and 987"); // 0
//        Object o = new Math008_myAtoi().myAtoi("-91283472332"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("9223372036854775808"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("2147483648"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
        Object o = new Math008_myAtoi().myAtoi("-5-"); // -5

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}