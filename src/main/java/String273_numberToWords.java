public class String273_numberToWords {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder res = new StringBuilder();
        int billion = num / 1000000000;

        num = num - billion * 1000000000;
        int million = num / 1000000;

        num = num - million * 1000000;
        int thousand = num / 1000;

        num = num - thousand * 1000;

        if (billion != 0) res.append(threeDigits(billion)).append(" Billion");

        if (million != 0) {
            if (billion != 0) res.append(" ");
            res.append(threeDigits(million)).append(" Million");
        }

        if (thousand != 0) {
            if (billion != 0 || million != 0) res.append(" ");
            res.append(threeDigits(thousand)).append(" Thousand");
        }

        if (num != 0) {
            if (billion != 0 || million != 0 || thousand != 0) res.append(" ");
            res.append(threeDigits(num));
        }
        return res.toString();
    }

    private String threeDigits(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        num = num - hundred * 100;
        int ten = num / 10;
        num = num - ten * 10;

        if (hundred > 0) sb.append(getEnglish(hundred)).append(" Hundred");
        if (ten != 0 || num != 0) if (hundred > 0) sb.append(" ");

        if (ten == 0) {
            if (num != 0) {
                sb.append(getEnglish(num));
            }
        } else if (ten == 1) {
            sb.append(getEnglishTeen(num));
        } else if (ten > 0) {
            sb.append(getEnglishTen(ten));
            if (num != 0) {
                sb.append(" ").append(getEnglish(num));
            }
        }
        return sb.toString();
    }

    private String getEnglishTeen(int unit) {
        switch (unit) {
            case 0:
                return "Ten";
            case 1:
                return "Eleven";
            case 2:
                return "Twelve";
            case 3:
                return "Thirteen";
            case 4:
                return "Fourteen";
            case 5:
                return "Fifteen";
            case 6:
                return "Sixteen";
            case 7:
                return "Seventeen";
            case 8:
                return "Eighteen";
            case 9:
                return "Nineteen";
        }
        return null;
    }

    private String getEnglish(int digit) {
        switch (digit) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return null;
    }

    private String getEnglishTen(int digit) {
        switch (digit) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String273_numberToWords().numberToWords(1000010);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}