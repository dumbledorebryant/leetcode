package pass;
import java.util.*;;
public class lc802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; i++) rg.add(new ArrayList<>());
        for (int i = 0; i < n; i++){
            int[] outs = graph[i];
            for (int next : outs){
                rg.get(next).add(i);
            }
            indegree[i] = graph[i].length;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                queue.addLast(i);
            }
                
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.removeFirst();
            ans.add(node);
            for (int next : rg.get(node)){
                indegree[next]--;
                if (indegree[next] == 0) queue.addLast(next);
            }
        }
        Collections.sort(ans);
        
        return ans;
    }
}
