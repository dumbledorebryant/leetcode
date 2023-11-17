package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc244 {
    Map<String, List<Integer>> map = new HashMap<>();
    public lc244(String[] wordsDict) {
        int n = wordsDict.length;
        for (int i = 0; i < n; i++){
            String str = wordsDict[i];
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        int m = a.size();
        int n = b.size();

        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while (i < m && j < n){
            int x = a.get(i);
            int y = b.get(j);
            if (x < y){
                i++;
            }
            else {
                j++;
            }
            ans = Math.min(ans, Math.abs(x - y));
        }
        return ans;
    }
}
