package pass;
import java.util.*;
public class lc212 {
    int m, n;
    List<String> ans = new ArrayList<String>();
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        int len = words.length;
        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < len; i++){
            String word = words[i];
            int key = word.charAt(0) - 'a';
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int key = board[i][j] - 'a';
                if (map.containsKey(key)){
                    List<String> list = map.get(key);
                    boolean[][] visited = new boolean[m][n];
                    StringBuilder sb = new StringBuilder();
                    dfs(board, i, j, sb, list, visited);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] board, int i, int j, StringBuilder sb, List<String> list, boolean[][] visited){
        String str = sb.toString();
        if (list.contains(str)){
            if (!set.contains(str)) {
                set.add(str);
                ans.add(str);
            } 
        }

        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (visited[i][j]) return;
        char ch = board[i][j];
        sb.append(ch);
        
        visited[i][j] = true;
        dfs(board, i + 1, j, sb, list, visited); 
        dfs(board, i - 1, j, sb, list, visited);
        dfs(board, i, j + 1, sb, list, visited);
        dfs(board, i, j - 1, sb, list, visited);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
}
