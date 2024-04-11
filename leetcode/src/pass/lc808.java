package pass;
import java.util.*;

public class lc808 {
    private int[] serveA = new int[]{100, 75, 50, 25};
    private int[] serveB = new int[]{0, 25, 50, 75};

    double[][] dp;
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;

        dp = new double[n + 1][n + 1]; 
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return backtracking(n, n);
    }

    public double backtracking(int al, int bl){
        if (al == 0 && bl == 0) return 0.5;
        if (bl == 0) return 0.0;
        if (al == 0) return 1.0;
        if (dp[al][bl] != -1) return dp[al][bl];
        double res = 0.0;
        for (int i = 0; i < 4; i++){
            int a = serveA[i];
            int b = serveB[i];

            res += 0.25 * backtracking(Math.max(0, al - a), Math.max(0, bl - b));
        }

        dp[al][bl] = res;
        return res;
    }
}
