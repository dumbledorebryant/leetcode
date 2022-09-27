package pass;

public class lc1905 {
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid2[i][j] == 1 && grid1[i][j] == 1){
                    if (dfs(grid1, grid2, i, j)) ans++;
                }
            }
        }
        return ans;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n) return true;
        int one = grid1[i][j];
        int two = grid2[i][j];

        if (two == 0) return true;
        if (one == 0) return false;
        grid2[i][j] = 0;
        grid1[i][j] = 0;
        return dfs(grid1, grid2, i + 1, j) &
               dfs(grid1, grid2, i - 1, j) &
               dfs(grid1, grid2, i, j + 1) &
               dfs(grid1, grid2, i, j - 1);
    }
}
