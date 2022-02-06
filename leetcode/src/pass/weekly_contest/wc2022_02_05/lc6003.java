package pass.weekly_contest.wc2022_02_05;

public class lc6003 {
    public int minimumTime(String s) {
        if (s.equals("0")) {
            return 0;
        }
        int N = s.length();
        int[] left = new int[N], right = new int[N];
        for (int i = 0; i < N; i++) {
            left[i] = Math.min((i == 0 ? 0 : left[i - 1]) + (s.charAt(i) == '1' ? 2 : 0), i + 1);
        }
        for (int i = N - 1; i >= 0; i--) {
            right[i] = Math.min((i == N - 1 ? 0 : right[i + 1]) + (s.charAt(i) == '1' ? 2 : 0), N - i);
        }
        int res = N;
        for (int i = 1; i < N; i++) {
            res = Math.min(res, left[i - 1] + right[i]);
        }
        
        return res;
    }
}
