package pass;

import java.util.HashMap;
import java.util.Map;

public class lc359 {
    Map<String, Integer> map = new HashMap<>();
    public lc359() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)){
            map.put(message, timestamp);
        }
        else {
            int pre = map.get(message);
            if (timestamp - pre >= 10){
                map.put(message, timestamp);
            }
            else return false;
        }
        return true;
    }
}
