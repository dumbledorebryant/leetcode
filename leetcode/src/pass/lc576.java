package pass;

import java.util.Arrays;

public class lc576 {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] memo;
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        }
        return dp(startRow, startColumn, maxMove);
    }

    public int dp(int i, int j, int k){
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (k == 0) return 0;
        if (memo[i][j][k] != -1) return memo[i][j][k];
        int sum = 0;
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            int res = dp(x, y, k - 1) % mod;
            sum += res;
            sum %= mod;
        }
        memo[i][j][k] = sum;
        return sum;
    }
}
