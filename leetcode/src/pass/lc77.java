package pass;
import java.util.*;
public class lc77 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n + 1];
        backtrace(n, 1, k, new ArrayList<>());
        return ans;
    }
    public void backtrace(int n, int idx, int cur, List<Integer> list){
        if (cur == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if (idx > n) return;
        for (int i = idx; i <= n; i++){
            if (visited[i]) continue;
            list.add(i);
            visited[i] = true;
            backtrace(n, i + 1, cur - 1, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
