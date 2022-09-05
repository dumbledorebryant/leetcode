package pass;

import java.util.Deque;
import java.util.LinkedList;

public class lc1730 {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '*'){
                    return bfs(grid, i, j);
                }
            }
        }
        return -1;
    }

    public int bfs(char[][] grid, int i, int j){
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] start = new int[]{i, j};
        visited[i][j] = true;
        queue.add(start);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int k = 0; k < size; k++){
                int[] pt = queue.poll();
                int x = pt[0];
                int y = pt[1];
                for (int[] dir : dirs){
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n)
                        continue;
                    
                    int[] npt = new int[]{xx, yy};
                    if (visited[xx][yy]) continue;
                    if (grid[xx][yy] == 'X') {
                        visited[xx][yy] = true;
                        continue;
                    }
                    if (grid[xx][yy] == '#') return step;
                    else {
                        queue.add(npt);
                        visited[xx][yy] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
