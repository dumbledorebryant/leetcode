package pass;

import java.util.*;

public class lc1436 {
    public String destCity(List<List<String>> paths) {
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        int length = paths.size();
        for (int i = 0; i < length; i++){
            String item = paths.get(i).get(0);
            if (!map.containsKey(item)){
                map.put(item, 1);
            }
        }

        for (int i = 0; i < length; i++){
            String item = paths.get(i).get(1);
            if (!map.containsKey(item)){
                ans = item;
            }
        }
        return ans;
    }
}
