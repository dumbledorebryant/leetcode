package pass;

import java.util.Arrays;

public class lc666 {
    public int pathSum(int[] nums) {
        int[][] path = new int[5][9];
        for (int[] p : path) Arrays.fill(p, -1);
        for (int n : nums){
            path[n / 100][(n % 100) / 10] = n % 10;
        }
        return sum(path, 1, 1, 0);
    }
    private int sum(int[][] path, int lvl, int idx, int sum){
        if (lvl >= 5 || idx >= 9 || path[lvl][idx] == -1) return 0;
        sum += path[lvl][idx];
        int r = sum(path, lvl + 1, idx*2,   sum);
        int l = sum(path, lvl + 1, idx*2-1, sum);
        return r + l == 0? sum : r + l;
    }
}
