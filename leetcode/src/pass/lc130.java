package pass;

import java.util.Arrays;

public class lc130 {
    int m;
    int n;
    boolean[][] visited;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                char ch = board[i][j];
                if (ch == 'O'){
                    if (check(i, j, board)) board[i][j] = 'X';
                }
            }
        }
    }
    public boolean check(int i, int j, char[][] board){
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        char ch = board[i][j];
        if (ch == 'X') return true;
        if (ch == '#') return false;
        if (visited[i][j]) return true;
        
        else {
            visited[i][j] = true;
            boolean flag = check(i + 1, j, board) 
                            && check(i - 1, j, board)
                            && check(i, j + 1, board)
                            && check(i, j - 1, board);
            visited[i][j] = false;
            if (flag == false) board[i][j] = '#';
            return flag;
        }
    }
}