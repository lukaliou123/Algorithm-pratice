package mix;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    /**
     * 两种解法，一种是直接重写removeEldestEntry,设置当size大于capacity
     */
    int capacity;
    //用双重链表
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity){
        this.capacity= capacity;
        //重写这个链哈希
        cache = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };

    }

    public int get(int key){
        return cache.getOrDefault(key,-1);
    }

    public void put(int key,int val){
        cache.put(key,val);
    }

}
