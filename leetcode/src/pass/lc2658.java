package pass;

public class lc2658 {
    int max = 0;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != 0){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (grid[i][j] == 0) return 0;

        int res = grid[i][j];
        grid[i][j] = 0;
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            res += dfs(grid, x, y);
        }
        return res;
    }
}
