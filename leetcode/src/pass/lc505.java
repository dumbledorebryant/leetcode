package pass;

public class lc505 {
    int m, n;
    int sx, sy;
    int dx, dy;
    boolean[][] visited;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        sx = start[0]; sy = start[1];
        dx = destination[0]; dy = destination[1];
        visited = new boolean[m][n];
        int ans = dfs(maze, sx, sy);
        return ans == -1 ? -1 : ans;
    }

    public int dfs(int[][] maze, int i, int j){
        if (visited[i][j]) return -1;
        if (i == dx && j == dy) return 0;

        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        for (int[] dir : dirs){
            int xx = dir[0];
            int yy = dir[1];
            int x = i + xx;
            int y = j + yy;
            int step = 0;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                step++;
                x += xx;
                y += yy;
            }
            x -= xx;
            y -= yy;
            System.out.println(step);
            if (!visited[x][y]){
                int res = dfs(maze, x, y);
                if (res == -1) continue;
                else if (res == 0) {
                    visited[i][j] = false;
                    return step;
                }
                step += res;
                min = Math.min(step, min);
            }
        }
        visited[i][j] = false;
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
