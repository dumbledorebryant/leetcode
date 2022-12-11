package pass.weekly_contest.wc2022_12_10;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc6257 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < m; i++){
            Arrays.sort(grid[i]);
        }   
        int ans = 0;
        for (int j = 0; j < n; j++){
            for (int i = 0; i < m; i++){
                queue.add(grid[i][j]);
            }
            ans += queue.poll();
            queue.clear();
        }
        return ans;
    }
}
