package pass;

public class lc1905 {
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid2[i][j] == 1 && grid1[i][j] == 0)
                    dfs(grid2, i, j);
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid2[i][j] == 1){
                    ans++;
                    dfs(grid2, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
