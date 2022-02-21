package pass;
import java.util.*;
public class lc212 {
    int m, n;
    List<String> ans = new ArrayList<String>();
    Set<String> set = new HashSet<>();
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited = new boolean[15][15];
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        for (String str : words) set.add(str);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(board, i, j, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i][j] = false;
            }
        }
        return ans;
    }
    public void dfs(char[][] board, int i, int j, StringBuilder sb){
        if (sb.length() > 10) return;
        String str = sb.toString();
        if (set.contains(str)){
            set.remove(str);
            ans.add(str);
        }

        for (int[] d : dirs){
            int dx = i + d[0];
            int dy = j + d[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (visited[dx][dy]) continue;

            visited[dx][dy] = true;
            sb.append(board[dx][dy]);
            dfs(board, dx, dy, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[dx][dy] = false;
        }
        return;
    }
}
