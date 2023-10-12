package pass;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc1366 {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for (String str : votes){
            for (int i = 0; i < len; i++){
                char ch = str.charAt(i);
                if (map.containsKey(ch)){
                    map.get(ch)[i]++;
                }
                else {
                    int[] cur = new int[len];
                    cur[i]++;
                    map.put(ch, cur);
                }
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            int[] m = map.get(a);
            int[] n = map.get(b);
            for (int i = 0; i < len; i++){
                if (m[i] > n[i]) return -1;
                if (m[i] < n[i]) return 1;
            }
            return a.compareTo(b);
        });

        for (char key : map.keySet()){
            pq.add(key);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
