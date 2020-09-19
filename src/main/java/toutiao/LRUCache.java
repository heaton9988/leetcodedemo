package toutiao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your toutiao.LRUCache object will be instantiated and called as such:
 * toutiao.LRUCache obj = new toutiao.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map  = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer res = map.get(key);
        if(res == null) {
            return -1;
        } else {
            map.remove(key);
            map.put(key, res);
            return res;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            map.put(key, value);
            if(map.size() > capacity) {
                Integer oldKey = map.keySet().iterator().next();
                map.remove(oldKey);
            }
        }
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