package pass;

public class lc2673 {
    int res = 0;
    public int minIncrements(int n, int[] cost) {
        dfs(0, cost);
        return res;
    }
    private int dfs(int i, int[] cost) {
        if (i >= cost.length) return 0;
        int a = dfs(2 * i + 1, cost), b = dfs(2 * i + 2, cost);
        res += Math.abs(a - b);
        return cost[i] + Math.max(a, b);
    }
}
