package pass;
import java.util.*;
public class lc380 {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    public lc380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            list.add(list.size(), val);
            map.put(val, list.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
