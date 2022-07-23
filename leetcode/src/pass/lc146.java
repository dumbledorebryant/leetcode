package pass;

import java.util.*;

public class lc146 {
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> dq = new LinkedList<>();
    List<Integer> array = new ArrayList<>();
    int cap;
    public lc146(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            dq.push(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > cap){
            dq.
            while (map.containsKey(dq.removeFirst())){
                map.remove(key)
            }
        }
    }
}
