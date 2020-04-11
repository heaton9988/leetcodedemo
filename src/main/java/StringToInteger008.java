public class StringToInteger008 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        int sign = 1;
        int sum = 0;

        int idx = 0;
        while (str.charAt(idx) == ' ') idx++;

        char first = str.charAt(idx);
        if (first == '+') idx++;
        else if (first == '-') {
            idx++;
            sign = -1;
        } else if (first < '0' || first > '9') return 0;

        while (idx < str.length()) {
            char c = str.charAt(idx++);
            if (c < '0' || c > '9') {
                break;
            } else {
                if (sum > (Integer.MAX_VALUE - (c - '0')) / 10) { // 判断溢出的标准方法
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                sum = sum * 10 + (c - '0');
            }
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        int i = new StringToInteger008().myAtoi("42");
        System.out.println(i);
    }
}