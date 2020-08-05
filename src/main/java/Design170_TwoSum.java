import java.util.HashMap;

public class Design170_TwoSum {
    public Design170_TwoSum() {
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void add(int number) {
        if (map.containsKey(number)) {
            int now = map.get(number);
            map.put(number, now + 1);
        } else {
            map.put(number, 1);
        }
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    public boolean find(int value) {
        if (value < min * 2 || value > max * 2)
            return false;
        for (int key : map.keySet()) {
            int now = map.get(key);
            if (map.containsKey(value - key)) {
                if (value - key == key && now == 1)
                    continue;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}