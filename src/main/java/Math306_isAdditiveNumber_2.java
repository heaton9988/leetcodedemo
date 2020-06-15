public class Math306_isAdditiveNumber_2 {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * @param num    原始字符串
     * @param len    原始字符串长度
     * @param idx    当前处理下标
     * @param sum    前面的两个数字之和
     * @param pre    前一个数字
     * @param k      当前是处理的第几个数字
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        if (idx == len) {
            return k > 2;
        }
        for (int right = idx; right < len; right++) {
            long cur = fetchCurValue(num, idx, right);
            // 剪枝：无效数字
            if (cur < 0) {
                continue;
            }
            // 剪枝：当前数字不等于前面两数之和
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, right + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取 l ~ r 组成的有效数字
     */
    private long fetchCurValue(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        Object o = new Math306_isAdditiveNumber_2().isAdditiveNumber("1235");
        System.out.println(o);
    }
}