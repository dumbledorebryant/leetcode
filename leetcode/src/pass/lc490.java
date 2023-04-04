package pass;

public class lc490 {
    int sx, sy;
    int dx, dy;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        sx = start[0];
        sy = start[1];
        dx = destination[0];
        dy = destination[1];
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, sx, sy, visited);
    }
    public boolean dfs(int[][] maze, int i, int j, boolean[][] visited){
        if (visited[i][j]) return false;
        if (i == dx && j == dy){
            return true;
        }        
        visited[i][j] = true;
        for (int[] dir : dirs){
            int xx = dir[0];
            int yy = dir[1];
            int x = i + xx;
            int y = j + yy;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                x += xx;
                y += yy;
            }
            x -= xx;
            y -= yy;
            if (!visited[x][y]){
                if (dfs(maze, x, y, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
