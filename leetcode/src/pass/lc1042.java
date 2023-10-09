package pass;

import java.util.ArrayList;
import java.util.List;

public class lc1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        List<Integer> grid[] = new List[n+1];
        for (int i = 1; i <= n; i++) {
            grid[i] = new ArrayList<>();
        }
        for(int[] x : paths){
            grid[x[0]].add(x[1]);
            grid[x[1]].add(x[0]);
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> garden = grid[i];
            int len = garden.size();
            boolean[] color = new boolean[5];
            for (int j = 0; j < len; j++) {
                color[ans[garden.get(j)-1]] = true;
            }
            for (int j = 1; j < 5; j++) {
                if(color[j] == false){
                    ans[i-1] = j;
                }
            }
        }
        return ans;

    }
}
