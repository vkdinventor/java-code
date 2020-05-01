import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

// see 30 day coding LeetCode.
class LRUCache {

    Map<Integer, Integer> map;
    private int capacity;

    public static void main(String[] args){
        // [[2],[2,1],[1,1],[2],[4,1],[1],[2]]

        LRUCache lruCache = new LRUCache(2);
        int v = 0;
        lruCache.put(2,1);
        lruCache.put(1,1);
        v = lruCache.get(2);
        lruCache.put(4,1);
        v = lruCache.get(1);
        v = lruCache.get(2);
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val == null) {
            return -1;
        } else {
            map.remove(key);
            map.put(key, val);
        }
        return val;
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            map.put(key, value);
        } else {
            map.remove(map.keySet().iterator().next());
            map.put(key, value);
        }

    }
}

class LRUCache2 {

    public Map<Integer, Integer> map;
    public int capacity;
    public Deque<Integer> queue;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        queue = new ArrayDeque<>(capacity);

    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val == null) {
            return -1;
        } else {
            Integer key2 = key;
            queue.remove(key2);
            queue.add(key2);
        }
        return val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            Integer key2 = key;
            queue.remove(key2);
            queue.add(key2);
        }else if (map.size() < capacity) {
            map.put(key, value);
            queue.add(key);
        } else {
            Integer key2 = queue.pollFirst();
            map.remove(key2);
            map.put(key, value);
            queue.add(key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */