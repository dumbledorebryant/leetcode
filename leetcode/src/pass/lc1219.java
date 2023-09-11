package pass;

public class lc1219 {
    int ans = 0;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != 0){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]){
            return 0;
        }
        int num = grid[x][y];
        visited[x][y] = true;
        int temp = 0;
        for (int[] dir : dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            temp = Math.max(temp, dfs(grid, i, j));
        }
        visited[x][y] = false;
        return num + temp;
    }
}
