package pass;

public class lc329 {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        memo = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int len = dfs(matrix, i, j);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
    
    public int dfs(int[][] matrix, int i, int j){
        int len = memo[i][j];
        if (len != 0) return len;
        
        len++;
        int num = matrix[i][j];
        for (int[] dir : dirs){
            int dx = i + dir[0];
            int dy = j + dir[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (matrix[dx][dy] <= num) continue;
            len = Math.max(len, dfs(matrix, dx, dy) + 1);
        }
        memo[i][j] = len;
        return len;
    }
}
