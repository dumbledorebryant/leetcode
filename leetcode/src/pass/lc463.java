package pass;

public class lc463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    ans += dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            return 1;
        }
        if (grid[i][j] == 2) return 0;
        
        grid[i][j] = 2;
        
        return dfs(grid, i + 1, j) 
            + dfs(grid, i - 1, j) 
            + dfs(grid, i, j + 1) 
            + dfs(grid, i, j - 1);
    }
}
