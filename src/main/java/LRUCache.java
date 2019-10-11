import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedList = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        int ret = -1;

        Integer value = linkedList.get(key);

        if (value != null) {
            ret = value;

            linkedList.remove(key);
            linkedList.put(key, value);
        }

        return ret;
    }

    public void put(int key, int value) {
        if (!linkedList.containsKey(key)) {
            if (linkedList.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer>> iterator = linkedList.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
        } else {
            linkedList.remove(key);
        }
        linkedList.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

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