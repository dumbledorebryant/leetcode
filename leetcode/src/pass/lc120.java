package pass;
import java.util.*;

public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < i; j++){
                int num = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + num;
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int ans = Arrays.stream(dp[n - 1]).min().getAsInt();
        return ans;
    }
}
