package pass;

public class lc526 {
    int ans = 0;
    boolean[] visited;
    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        backtrace(n, 1);
        return ans;
    }
    public void backtrace(int n, int idx){
        if (idx == n + 1){
            ans++;
            return;
        } 

        for (int i = 1; i <= n; i++){
            if (visited[i]) continue;
            if (i % idx == 0 || idx % i == 0){
                visited[i] = true;
                backtrace(n, idx + 1);
                visited[i] = false;
            }
        }
    }
}
