public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }
        s = s.replaceAll("IV", "IIII");
        s = s.replaceAll("IX", "VIIII");
        s = s.replaceAll("XL", "XXXX");
        s = s.replaceAll("XC", "LXXXX");

        s = s.replaceAll("CD", "CCCC");
        s = s.replaceAll("CM", "DCCCC");

        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'I') sum += 1;
            if (c == 'V') sum += 5;
            if (c == 'X') sum += 10;
            if (c == 'L') sum += 50;
            if (c == 'C') sum += 100;
            if (c == 'D') sum += 500;
            if (c == 'M') sum += 1000;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        long start = System.currentTimeMillis();
        System.out.println(obj.romanToInt("MCMXCIV"));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}