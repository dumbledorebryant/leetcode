package pass;
import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class lc690 {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> imap = new HashMap<>();
    int ans = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees){
            graph.put(e.id, e.subordinates);
            imap.put(e.id, e.importance);
        }
        ans += imap.get(id);
        dfs(graph, id);
        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> graph, int id){
        if (!graph.containsKey(id)) return;

        List<Integer> subordinates = graph.get(id);
        for (int sub_id : subordinates){
            ans += imap.get(sub_id);
            dfs(graph, sub_id);
        }
    }
}
