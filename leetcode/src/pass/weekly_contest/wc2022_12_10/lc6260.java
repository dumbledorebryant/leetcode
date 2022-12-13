package pass.weekly_contest.wc2022_12_10;

public class lc6260 {
    boolean[][] visited;
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            visited = new boolean[m][n];
            ans[i] = dfs(grid, 0, 0, queries[i]);
        }
        return ans;
    }

    int dfs(int[][] grid, int i, int j, int ele){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if (visited[i][j]) return 0;
        int num = grid[i][j];
        if (num >= ele) return 0;
        visited[i][j] = true;
        return 1 + dfs(grid, i + 1, j, ele)
                + dfs(grid, i - 1, j, ele)
                + dfs(grid, i, j + 1, ele)
                + dfs(grid, i, j - 1, ele);
    }
}
