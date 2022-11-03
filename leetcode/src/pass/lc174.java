package pass;

import java.util.Arrays;

public class lc174 {
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length; 
        int n = dungeon[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return backtrace(dungeon, 0, 0);
    }

    public int backtrace(int[][] grid, int i, int j){
        int m = grid.length; 
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (memo[i][j] != -1) return memo[i][j];

        int num = grid[i][j];
        int need = Math.min(backtrace(grid, i + 1, j), 
                            backtrace(grid, i, j + 1)) - num;
                            
        int ans = need <= 0 ? 1 : need;
        memo[i][j] = ans;
        return ans;
    }
}
