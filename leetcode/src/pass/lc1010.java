package pass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int length = time.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            int num = time[i];
            int left = num % 60;
            time[i] = left;
            map.put(left, map.getOrDefault(left, 0) + 1);
        }
        int count = 0;
        if (map.containsKey(0)){
            int n0 = map.get(0);
            count += ((n0 * (n0 - 1))/2);
        }
        if (map.containsKey(30)){
            int n30 = map.get(30);
            count += ((n30 * (n30 - 1))/2);
        }
        for (int i = 1; i < 30; i++){
            if (map.containsKey(i) && map.containsKey(60 - i))
                count += (map.get(i) * map.get(60 - i));
        }
        return count;
    }
}
