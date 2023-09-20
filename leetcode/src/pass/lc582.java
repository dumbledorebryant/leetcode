package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc582 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        for (int i = 0; i < n; i++){
            int parent = ppid.get(i);
            int child = pid.get(i);
            map.putIfAbsent(parent, new HashSet<>());
            map.get(parent).add(child);
        }
        ans.add(kill);
        dfs(kill);
        return ans;
    }

    public void dfs(int kill){
        if (map.containsKey(kill)){
            Set<Integer> set = map.get(kill);
            for (int num : set){
                ans.add(num);
                dfs(num);
            }
        }
    }
}