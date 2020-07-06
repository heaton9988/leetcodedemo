public class DP044_isMatch_greedy {
    public boolean isMatch(String s, String p) {
        int sEnd = s.length(), pEnd = p.length();
        while (sEnd > 0 && pEnd > 0 && p.charAt(pEnd - 1) != '*') {
            if (charMatch(s.charAt(sEnd - 1), p.charAt(pEnd - 1))) {
                --sEnd;
                --pEnd;
            } else {
                return false;
            }
        }
        if (pEnd == 0) return sEnd == 0;

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sEnd && pIndex < pEnd) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sEnd) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        for (int i = pIndex; i < pEnd; ++i) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(new DP044_isMatch_greedy().isMatch("mississippi", "m??*ss*?i*pi")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("1aa1bb1ccc1", "**aa*bb**cc**")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("a", "a*")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("a", "*a")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("aa", "a")); // false
        System.out.println(new DP044_isMatch_greedy().isMatch("aa", "*")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("cb", "?a")); // false
        System.out.println(new DP044_isMatch_greedy().isMatch("adceb", "*a*b")); // true
        System.out.println(new DP044_isMatch_greedy().isMatch("acdcb", "a*c?b")); // false
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}