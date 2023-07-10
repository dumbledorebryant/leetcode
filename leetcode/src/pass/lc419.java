package pass;

public class lc419 {
    
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'X'){
                    dfs(board, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '.'){
            return;
        }

        board[i][j] = '.';
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(board, x, y);
        }
    }
}
