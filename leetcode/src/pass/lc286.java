package pass;

import java.util.LinkedList;

import java.util.*;

public class lc286 {
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int dis = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                rooms[x][y] = dis;
                for (int[] dir : dirs){
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                    if (visited[dx][dy] || rooms[dx][dy] == -1) continue;
                    queue.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
            dis++;
        }       
    }
}
