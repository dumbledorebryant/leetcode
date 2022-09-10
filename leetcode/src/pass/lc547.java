package pass;

import java.util.*;

public class lc547 {
    int m;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected[0] == null) return 0;
        int count = 0;
        m = isConnected.length;
        boolean[][] visited = new boolean[m][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++)
        }
        return count;
    }

    public void search(int[][] grid, int i, int j, Set<Integer> path, boolean[][] visited){
        if (i < 0 || j < 0 || j >= m || i >= m) return;
        if (visited[i][j]) return;
        int num = grid[i][j];
        if (num != 0){
            if (!path.contains(i)) path.add(i);
            if (!path.contains(j)) path.add(j);
            
        }
        return;
    }
}
