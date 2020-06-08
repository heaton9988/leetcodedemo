public class Math008_myAtoi_answer {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new Math008_myAtoi().myAtoi("   -42");
//        Object o = new Math008_myAtoi().myAtoi("4193 with words");
//        Object o = new Math008_myAtoi().myAtoi("words and 987"); // 0
//        Object o = new Math008_myAtoi().myAtoi("-91283472332"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("9223372036854775808"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
//        Object o = new Math008_myAtoi().myAtoi("2147483648"); // 超过 32 位有符号整数范围。因此返回 INT_MIN (−231)
        Object o = new Math008_myAtoi_answer().myAtoi("-5-"); // -5

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}