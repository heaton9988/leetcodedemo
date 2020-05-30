public class String158_read {
    private char[] fileBuf = new char[4];
    private int readOffset = 0;
    private int bufSize = 0;
    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            char nextChar = getNextCharFromFile();
            if (nextChar == 0) {
                return i;
            } else {
                buf[i] = nextChar;
            }
        }
        return n;
    }

    public char getNextCharFromFile() {
        if (readOffset == bufSize) {
            //buf is full
            //need new read
            bufSize = read4(fileBuf);
            readOffset = 0;
            if (bufSize == 0) {
                return 0;
            }
        }
        return fileBuf[readOffset++];
    }

    private int read4(char[] buff) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
//        Object o = new String158_read().strobogrammaticInRange("50", "1000");
//        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}