package pass;

import java.util.*;

public class lc694 {
    int m, n;
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 1);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int k){
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append("#").append(k);
        dfs(grid, i + 1, j, sb, 1);
        dfs(grid, i - 1, j, sb, 2);
        dfs(grid, i, j + 1, sb, 3);
        dfs(grid, i, j - 1, sb, 4);
    }
}
