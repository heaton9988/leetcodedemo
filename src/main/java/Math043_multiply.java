public class Math043_multiply {
    public String multiply(String num1, String num2) { // 45 * 123
        int s = num1.length(), l = num2.length();
        if (s > l) return multiply(num2, num1);

        int resLen = s + l + 1;
        int[] res = new int[resLen];
        int times = 0;
        for (int i = s - 1; i >= 0; i--) { // 45
            int smallVal = num1.charAt(i) - '0';
            int inversionOrder = times++;//
            for (int j = l - 1; j >= 0; j--) {
                int longVal = num2.charAt(j) - '0';
                res[resLen - 1 - inversionOrder++] += smallVal * longVal;
            }
        }
        repair(res);
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int d : res) {
            if (flag && d == 0) continue;
            else {
                flag = false;
                sb.append(d);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private void repair(int[] res) {
        int last = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += last;
            last = res[i] / 10;
            if (res[i] / 10 > 0) {
                res[i] = res[i] % 10;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Math043_multiply().multiply("123", "456");

        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}