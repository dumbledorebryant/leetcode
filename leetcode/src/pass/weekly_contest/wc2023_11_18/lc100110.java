package pass.weekly_contest.wc2023_11_18;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc100110 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        Arrays.fill(res, -1);

        int n = heights.length;
        
        for (int i = 0; i < m; i++){
            int[] q = queries[i];
            int a = q[0];
            int b = q[1];
            if (a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b){
                res[i] = a;
                continue;
            }

            for (int j = b; j < n; j++){
                int num = heights[j];
                if (j == b && num > heights[a]){
                    res[i] = j;
                    break;
                }
                if (num > heights[a] && num > heights[b]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
