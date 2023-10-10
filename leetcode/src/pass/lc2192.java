package pass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2192 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            graph[to].add(from);
        }
        
        for (int i = 0; i < n; i++){
            Set<Integer> set = dfs(graph, i);
            List<Integer> list = new ArrayList<>();
            list.addAll(set);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

    public Set<Integer> dfs(List<Integer>[] graph, int i){
        if (map.containsKey(i)) return map.get(i);
        List<Integer> list = graph[i];

        Set<Integer> res = new HashSet<>();
        res.addAll(list);
        for (int next : list){
            res.addAll(dfs(graph, next));
        }
        map.put(i, res);
        return res;
    }
}
