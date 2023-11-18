package pass;

import java.util.*;
import java.util.Map.Entry;

public class lc451 {
    public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
    
            int n = s.length();
            for (int i = 0; i < n; i++){
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
    
            PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a));
    
            for (char ch : map.keySet()){
                pq.add(ch);
            } 
    
            StringBuilder sb = new StringBuilder();
    
            while (!pq.isEmpty()){
                char ch = pq.poll();
                for (int i = 0; i < map.get(ch); i++){
                    sb.append(ch);
                }
            }
            return sb.toString();
        
    }
}
