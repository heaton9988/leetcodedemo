import java.util.*;

public class Design146_LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int size;

    public Design146_LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) return -1;
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() >= size) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
        } else {
            map.remove(key);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design146_LRUCache obj = new Design146_LRUCache(3);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}