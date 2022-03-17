package pass;
import java.util.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;
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

    Map<String, Integer> sset = new HashMap<>();
    boolean[][] visit = new boolean[m][n];
    public List<String> cisco(char[][] board, String[] words){
        int m = board.length;
        int n = board[0].length;
        
        for (String word : words) sset.put(word, 0);
        

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                visit[i][j] = true;
                sb.append(board[i][j]);
                for (int z = 0; z < 4; z++)
                    dfsss(board, i, j, sb, z);
                sb.deleteCharAt(sb.length() - 1);
                visit[i][j] = false;
            }
        }
        return ans;
    }

    public void dfsss(char[][] board, int i, int j, StringBuilder sb, int z){
        String str = sb.toString();
        if (sset.containsKey(str)){
            sset.put(str, 1);
        }
        if (z == 0){ // down
            int x = i + 1;
            if (x >= m) return;
            sb.append(board[x][j]);
            visit[x][j] = true;
            dfsss(board, x, j, sb, z);
            visit[x][j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (z == 1){ // up
            int x = i - 1;
            if (x < 0) return;
            sb.append(board[x][j]);
            visit[x][j] = true;
            dfsss(board, x, j, sb, z);
            visit[x][j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (z == 2){ // left
            int y = j - 1;
            if (y < 0) return;
            sb.append(board[i][y]);
            visit[i][y] = true;
            dfsss(board, i, y, sb, z);
            visit[i][y] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (z == 3){ // right
            int y = j + 1;
            if (y >= n) return;
            sb.append(board[i][y]);
            visit[i][y] = true;
            dfsss(board, i, y, sb, z);
            visit[i][y] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
