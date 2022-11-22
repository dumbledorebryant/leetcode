package pass;

import java.util.*;

public class lc1926 {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        int ans = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] pt = queue.removeFirst();
                int x = pt[0];
                int y = pt[1];
                for (int[] dir : dirs){
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                    if (maze[dx][dy] == '+') continue;
                    if (visited[dx][dy]) continue;
                    if (dx == 0 || dx == m - 1 || dy == 0 || dy == n - 1) return ans;
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }
            }
            ans++;
        }
        return -1;
    }
}
