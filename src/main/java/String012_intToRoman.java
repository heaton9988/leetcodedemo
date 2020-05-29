public class String012_intToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int thousand = num / 1000;
        switch (thousand) {
            case 3:
                res.append("MMM");
                break;
            case 2:
                res.append("MM");
                break;
            case 1:
                res.append("M");
                break;
            default:
                break;
        }
        num = num - 1000 * thousand;
        int hundred = num / 100;
        switch (hundred) {
            case 9:
                res.append("CM");
                break;
            case 8:
                res.append("DCCC");
                break;
            case 7:
                res.append("DCC");
                break;
            case 6:
                res.append("DC");
                break;
            case 5:
                res.append("D");
                break;
            case 4:
                res.append("CD");
                break;
            case 3:
                res.append("CCC");
                break;
            case 2:
                res.append("CC");
                break;
            case 1:
                res.append("C");
                break;
            default:
                break;
        }
        num = num - 100 * hundred;
        int ten = num / 10;
        switch (ten) {
            case 9:
                res.append("XC");
                break;
            case 8:
                res.append("LXXX");
                break;
            case 7:
                res.append("LXX");
                break;
            case 6:
                res.append("LX");
                break;
            case 5:
                res.append("L");
                break;
            case 4:
                res.append("XL");
                break;
            case 3:
                res.append("XXX");
                break;
            case 2:
                res.append("XX");
                break;
            case 1:
                res.append("X");
                break;
            default:
                break;
        }
        num = num - 10 * ten;
        switch (num) {
            case 9:
                res.append("IX");
                break;
            case 8:
                res.append("VIII");
                break;
            case 7:
                res.append("VII");
                break;
            case 6:
                res.append("VI");
                break;
            case 5:
                res.append("V");
                break;
            case 4:
                res.append("IV");
                break;
            case 3:
                res.append("III");
                break;
            case 2:
                res.append("II");
                break;
            case 1:
                res.append("I");
                break;
            default:
                break;
        }
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String012_intToRoman().intToRoman(1994);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}