package pass;

import java.util.*;

public class lc505 {
    int m, n;
    int sx, sy;
    int dx, dy;
    boolean[][] visited;
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        sx = start[0];
        sy = start[1];
        dx = destination[0];
        dy = destination[1];
        visited = new boolean[m][n];
        int ans = dfs(maze, sx, sy);
        return ans == -1 ? -1 : ans;
    }

    public int dfs(int[][] maze, int i, int j) {
        if (visited[i][j])
            return -1;
        if (i == dx && j == dy)
            return 0;

        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int xx = dir[0];
            int yy = dir[1];
            int x = i + xx;
            int y = j + yy;
            int step = 0;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                step++;
                x += xx;
                y += yy;
            }
            x -= xx;
            y -= yy;
            if (visited[x][y])
                continue;

            int res = dfs(maze, x, y);
            if (res == -1)
                continue;
            else if (res == 0) {
                visited[i][j] = false;
                return step;
            } else {
                step += res;
                min = Math.min(step, min);
            }

        }
        visited[i][j] = false;
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    public int sDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return 0;
        int row = maze.length;
        int col = maze[0].length;

        int[][] dummy = new int[row][col];
        for (int[] m : dummy)
            Arrays.fill(m, Integer.MAX_VALUE);
        dummy[start[0]][start[1]] = 0;

        dfs(maze, dummy, start, destination);
        return dummy[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dummy[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[][] dummy, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;

        if (dummy[start[0]][start[1]] == dummy[destination[0]][destination[1]])
            return;

        for (int[] d : dirs) {
            int cnt = 0;
            int x = start[0] + d[0];
            int y = start[1] + d[1];
            while (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0 && maze[x][y] != 1) {
                x += d[0];
                y += d[1];
                cnt++;
            }

            if (dummy[start[0]][start[1]] + cnt < dummy[x - d[0]][y - d[1]]) {
                dummy[x - d[0]][y - d[1]] = dummy[start[0]][start[1]] + cnt;
                dfs(maze, dummy, new int[] { x - d[0], y - d[1] }, destination);
            }
        }
    }
}
