package pass;

public class lc1034 {
    boolean[][] visited;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int pre = -1;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        pre = grid[row][col];
        dfs(grid, row, col, color);
        return grid;
    }

    public boolean dfs(int[][] grid, int i, int j, int color){
        if (i < 0 || i >= m || j < 0 || j >= n) return true;
        if (visited[i][j]) return false;
        if (grid[i][j] != pre) return true;

        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            boolean flag = dfs(grid, x, y, color);
            res = res || flag;
        }
        if (res) grid[i][j] = color;
        return false;
    }
}
