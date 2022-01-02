package pass;

public class lc547 {
    int m;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected[0] == null) return 0;
        int count = 0;
        m = isConnected.length;
        for (int i = 0; i < m; i++){
            if (isConnected[i][i] != 0){
                for (int j = 0; j < m; j++){
                    search(isConnected, i, j);
                }
                count++;
            }
        }
        return count;
    }

    public void search(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || j >= m || i >= m) return;
        int num = grid[i][j];
        if (num != 0){
            grid[i][i] = 0;
            grid[j][j] = 0;
        }
        return;
    }
}
