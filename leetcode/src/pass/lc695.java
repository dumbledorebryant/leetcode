package pass;
import java.util.*;

public class lc695 {
    int m;
    int n;
    Map<int[], Integer> map = new HashMap<>();
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;
        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int num = grid[i][j];
                if (num == 1) max = Math.max(max, area(grid, i, j));
            }
        }
        return max;
    }

    public int area(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        int num = grid[i][j];
        if (num == 0) return 0;
        
        grid[i][j] = 0;
        int count = area(grid, i + 1, j) + area(grid, i - 1, j) + 
                    area(grid, i, j + 1) + area(grid, i, j - 1) + 1;
        return count;
    }
}
