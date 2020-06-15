public class Math306_isAdditiveNumber {
    String s;
    int n;

    public boolean isAdditiveNumber(String num) {
        this.s = num;
        this.n = num.length();
//        return dfs(0, -1, -1);
        return false;
    }

//    private boolean dfs(int index, int num1, int num2) {
//        if (index >= n) return true;
//
//        if (num1 == -1) {
//            int sum = 0;
//            int digit = s.charAt(index++) - '0';
//            sum = sum * 10 + digit;
//        }
//
//
//    }

    public static void main(String[] args) {
        Object o = new Math306_isAdditiveNumber().isAdditiveNumber("1122335588");
        System.out.println(o);
    }
}