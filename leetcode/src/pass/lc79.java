package pass;

public class lc79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (check(board, visited, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    public boolean check(char[][] board, boolean[][] visited, int i, int j, int index, String str){
        int slen = str.length();
        if (index >= slen) return true;
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j] == true) return false;
        char ch = str.charAt(index);
        if (board[i][j] == ch){
            visited[i][j] = true;
            boolean flag = check(board, visited, i - 1, j, index + 1, str)
                            || check(board, visited, i + 1, j, index + 1, str)
                            || check(board, visited, i, j - 1, index + 1, str)
                            || check(board, visited, i, j + 1, index + 1, str);
            if (flag) return true;
            else {
                visited[i][j] = false;
                return false;
            }
        }
        return false;
    }
}
