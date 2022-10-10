package pass;

import java.util.*;

public class lc216 {
    List<List<Integer>> ans = new ArrayList<>();
    int k;
    boolean[] visited = new boolean[9];
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        backtrace(1, k, n, new ArrayList<>());
        return ans;
    }
    public void backtrace(int idx, int cur, int n, List<Integer> path){
        if (cur == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (cur == 0 || n <= 0) return;

        for (int i = idx; i <= 9; i++){
            if (visited[i - 1]) continue;
            
            path.add(i);
            visited[i - 1] = true;
            backtrace(i + 1, cur - 1, n - i, path);
            visited[i - 1] = false;
            path.remove(path.size() - 1);
        }
    }
}
