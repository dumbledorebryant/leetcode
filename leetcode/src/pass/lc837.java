package pass;

public class lc837 {
    public double new21Game(int n, int k, int maxPts) {
        if (k - 1 + maxPts <= n) return 1;
        // dp[i] 表示手上有 i 分时获胜的概率
        double[] dp = new double[k - 1 + maxPts + 1];
        // i 在 [k, n] 的范围上获胜概率为 100%，i 在 [n + 1, k - 1 + maxPts] 范围内获胜的概率为0
        double sumWindow = 0.0;  // sumWindow 记录固定滑动窗口内的获胜的概率和
        for (int i = k; i <= n; i++) {
            dp[i] = 1.0;
            sumWindow += dp[i];
        }

        int left = k - 1, right = k - 1 + maxPts;
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = sumWindow / maxPts;
            sumWindow = sumWindow + dp[left--] - dp[right--]; // 每次窗口移动一位，左进右出
        }

        return dp[0];
    }
}
