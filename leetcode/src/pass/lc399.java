package pass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc399 {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    double[] ans;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int m = queries.size();
        ans = new double[m];
        Arrays.fill(ans, -1.0);
        int n = equations.size();
        for (int i = 0; i < n; i++){
            List<String> pair = equations.get(i);
            String a = pair.get(0);
            String b = pair.get(1);
            if (!graph.containsKey(a)){
                graph.put(a, new HashMap<>());
            }
            if (!graph.containsKey(b)){
                graph.put(b, new HashMap<>());
            }
            Map<String, Double> alist = graph.get(a);
            Map<String, Double> blist = graph.get(b);
            alist.put(b, values[i]);
            blist.put(a, 1/values[i]);
        }

        for (int i = 0; i < m; i++){
            List<String> list = queries.get(i);
            Map<String, Boolean> visited = new HashMap<>();
            String a = list.get(0);
            String b = list.get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) continue;
            dfs(a, b, 1.0, i, visited);
        }
        return ans;
    }
    
    public void dfs(String a, String b, double pre, int idx, Map<String, Boolean> visited){
        if (visited.containsKey(a)) return;
        visited.put(a, true);
        Map<String, Double> nexts = graph.get(a);
        if (nexts.containsKey(b)){
            ans[idx] = pre * nexts.get(b);
        }

        for (String str : nexts.keySet()){
            double temp = pre * nexts.get(str);
            dfs(str, b, temp, idx, visited);
        }
    }
}
