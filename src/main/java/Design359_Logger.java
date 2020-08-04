import java.util.HashMap;

public class Design359_Logger {
    HashMap<String, Integer> map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int ts = map.get(message);
            if (timestamp - ts >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Design359_Logger logger = new Design359_Logger();

// 日志内容 "foo" 在时刻 1 到达系统
        logger.shouldPrintMessage(1, "foo"); // returns true;

// 日志内容 "bar" 在时刻 2 到达系统
        logger.shouldPrintMessage(2, "bar"); //returns true;

// 日志内容 "foo" 在时刻 3 到达系统
        logger.shouldPrintMessage(3, "foo"); //returns false;

// 日志内容 "bar" 在时刻 8 到达系统
        logger.shouldPrintMessage(8, "bar"); //returns false;

// 日志内容 "foo" 在时刻 10 到达系统
        logger.shouldPrintMessage(10, "foo"); //returns false;

// 日志内容 "foo" 在时刻 11 到达系统
        logger.shouldPrintMessage(11, "foo"); //returns true;

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}