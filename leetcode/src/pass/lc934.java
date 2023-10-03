package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc934 {
    boolean[][] visited;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ans = 0;
    Deque<Pair> queue = new ArrayDeque<>();
    class Pair{
        int x;
        int y;
        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    dfs(grid, i, j);
                    bfs(grid);
                    return ans;
                }
            }
        }
        
        return ans;
    }

    public void dfs(int[][] grid, int i, int j){
        int n = grid.length;
       
        visited[i][j] = true;
        queue.addLast(new Pair(i, j));
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            if (visited[x][y]) continue;
            if (grid[x][y] == 0) continue;
            dfs(grid, x, y);
        }
    }

    public void bfs(int[][] grid){
        int n = grid.length;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Pair cur = queue.removeFirst();
                int x = cur.x;
                int y = cur.y;
                for (int[] dir : dirs){
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
                    if (visited[xx][yy]) continue;
                    if (grid[xx][yy] == 1) return;
                    visited[xx][yy] = true;
                    queue.addLast(new Pair(xx, yy));
                }
            }
            ans++;
        }
    }
}
