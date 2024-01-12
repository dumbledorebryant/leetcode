package pass;

public class lc1947 {
    int max;
    boolean[] used;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;

        used = new boolean[m];
        backtrack(students, mentors, 0, 0);
        return max;
    }

    public void backtrack(int[][] students, int[][] mentors, int idx, int score){
        int m = students.length;
        int n = students[0].length;
        if (idx >= m){
            max = Math.max(max, score);
            return;
        }

        for (int i = 0; i < m; i++){
            if (used[i]) continue;
            int cur = calc(students[idx], mentors[i]);

            used[i] = true;
            score += cur;
            backtrack(students, mentors, idx + 1, score);
            score -= cur;
            used[i] = false;
        }
    }

    public int calc(int[]s, int[] m){
        int n = s.length;
        int res = 0;
        for (int i = 0; i < n; i++){
            if (s[i] == m[i]) res++;
        }
        return res;
    }
}
