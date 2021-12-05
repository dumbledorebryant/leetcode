package pass;

public class lc64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        ans[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            ans[i][0] = grid[i][0] + ans[i - 1][0];
        }

        for (int j = 1; j < n; j++){
            ans[0][j] = grid[0][j] + ans[0][j - 1];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                ans[i][j] = Math.min(ans[i][j - 1], ans[i - 1][j]) + grid[i][j];
            }
        }

        return ans[m - 1][n - 1];
    }
}
