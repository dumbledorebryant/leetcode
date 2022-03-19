package pass;

public class lc289 {
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (checkn(board, i, j)) flag = true;
                }
            }
        }
    }
    public boolean checkn(int[][] board, int i, int j){
        int[][] dirs = new int[][]{{1, 1}, {1, 0}, {1, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}};
        int count = 0;
        for (int[] dir : dirs){
            int dx = i + dir[0];
            int dy = j + dir[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (board[dx][dy] == 1) count++;
        }
        int num = board[i][j];
        if (num == 1 && count < 2) {
            board[i][j] = 0;
            return true;
        }
        if (num == 1 && (count == 2 || count == 3)) {
            board[i][j] = 1;
            return true;
        }
        if (num == 1 && count > 3) {
            board[i][j] = 0;
            return true;
        }
        if (num == 0 && count == 3) {
            board[i][j] = 1;
            return true;
        }
        return false;
    }
}
