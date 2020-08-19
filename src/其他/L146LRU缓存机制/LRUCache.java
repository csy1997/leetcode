package 其他.L146LRU缓存机制;

import java.util.*;

/**
 * 直接继承LinkedHashMap也可以
 */
public class LRUCache {
    private int capacity;
    private ArrayList<Integer> queue;
    private HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        boolean isValid = queue.remove(Integer.valueOf(key));
        if (isValid) {
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        queue.remove(Integer.valueOf(key));
        queue.add(key);
        map.put(key, value);
        if (queue.size() == capacity + 1) {
            int lastKey = queue.remove(0);
            map.remove(lastKey);
        }
    }
}
