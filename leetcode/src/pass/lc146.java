package pass;

import java.util.*;

public class lc146 {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;
    public lc146(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
        }
        else {
            
        }
        if (size == cap){
            cache.remove(cache.keySet().iterator().next());
        }
    }
}
