package pass;

public class lc391 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0'){
                    ans = Math.max(ans, bomb(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int bomb(char[][] grid, int i, int j){
        System.out.println("lalala");
        System.out.println("xy: " + i + " " + j);
        System.out.println("iiijjj");
        int m = grid.length;
        int n = grid[0].length;
        int rcnt = 0;
        int ccnt = 0;
        int x = i;
        int y = j;
        
            while (x >= 0){
                if (grid[x][y] == 'E') rcnt++;
                if (grid[x][y] == 'W') break;
                x--;
            }

            x = i;
            while (x < m){
                if (grid[x][y] == 'E') rcnt++;
                if (grid[x][y] == 'W') break;
                x++;
            }
            x = i;
        
        y = j;
       
            while (y >= 0){
                if (grid[x][y] == 'E') ccnt++;
                if (grid[x][y] == 'W') break;
                y--;
            }
            
            y = j;
            while (y < n){
                if (grid[x][y] == 'E') ccnt++;
                if (grid[x][y] == 'W') break;
                y++;
            }
        
        

        return rcnt + ccnt;
    }
}
