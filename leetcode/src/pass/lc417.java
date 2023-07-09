package pass;

import java.util.*;

public class lc417 {
    int m, n;
    boolean p, a;
    boolean[][] visited;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        p = false;
        a = false;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                visited = new boolean[m][n];
                visited[i][j] = true;
                dfs(heights, i, j);
                if (p && a){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
                p = false;
                a = false;
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, int i, int j){
        if (p && a) return;
        visited[i][j] = true;
        if (i == 0 || j == 0) {
            p = true;
        }
        if (i == m - 1 || j == n - 1){
            a = true;
        }

        int num = heights[i][j];
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y])
                continue;
            if (heights[x][y] <= num)
                dfs(heights, x, y); 
        }
        visited[i][j] = false;
    }
}
