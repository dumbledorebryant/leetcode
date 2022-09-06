package pass.OA.Amazon.OA;

import java.util.HashMap;
import java.util.Map;

public class cpus {
    public int cpuProcessor(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, i);
        }
        int sum = 0;
        for (int i : arr){
            sum += map.get(i);
            map.put(i, (int)Math.ceil(map.get(i) / 2.0));
        }
        return sum;
    }
}
