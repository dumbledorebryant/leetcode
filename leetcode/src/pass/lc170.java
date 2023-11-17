package pass;

import java.util.HashMap;
import java.util.Map;

public class lc170 {
    Map<Integer, Integer> map = new HashMap<>();
    public TwoSum() {
        
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (int key : map.keySet()){
            int left = value - key;
            if (map.containsKey(value - key)) {
                if (left == key){
                    if (map.get(key) >= 2) return true;
                }
                else return true;
            }
        }
        return false;
    }
}
