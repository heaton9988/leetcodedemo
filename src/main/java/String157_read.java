public class String157_read {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int temp;
        char[] tempArr = new char[4];
        int tempIndex = 0;
        while (count < n) {
            temp = read4(tempArr);
            if (temp == 0) break;
            while (tempIndex < temp && count < n) {
                buf[count] = tempArr[tempIndex];
                tempIndex++;
                count++;
            }
            tempIndex = 0;
        }
        return count;
    }

    private int read4(char[] buff) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
//        Object o = new String157_read().read("50", "1000");
//        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}