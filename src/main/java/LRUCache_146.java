import java.util.*;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache_146 {
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache_146(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() >= capacity) {
                Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
                map.remove(entrySet.iterator().next().getKey());
            }
        } else {
            map.remove(key);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache_146 cache = new LRUCache_146(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);// returns 1
        cache.put(3, 3);    // evicts key 2
        int i1 = cache.get(2);// returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int i2 = cache.get(1);// returns -1 (not found)
        int i3 = cache.get(3);// returns 3
        int i4 = cache.get(4);// returns 4

        System.out.println();
    }
}