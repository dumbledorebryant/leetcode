package pass.OA.Cisco;
import java.util.*;
public class ciscows {
    // at each cell we have 4 direction to move forward
    static int[] x = {-1, 0, 0, 1};
    static int[] y = {0, -1, 1, 0};

    // search2D method to search within grid
    static boolean search2D(char[][] grid, int row, int col, String word) {
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }

        int len = word.length();
        for (int dir = 0; dir < 4; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];
            for (k = 1; k < len; k++) {
                if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
                    break;
                }
                if (grid[rd][cd] != word.charAt(k)) {
                    break;
                }
                rd += x[dir];
                cd += y[dir];
            }
            if (k == len) {
                return true;
            }
        }
        return false;
    }

    // matching with the pattern
    static boolean patternSearch(char[][] grid, String word) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (search2D(grid, row, col, word)){
                    return true;
                }
            }
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {

        // grid declaration
        char[][] grid = {{'C', 'A', 'T'}, {'I', 'D', 'O'}, {'M', 'O', 'M'}};

        // search words
        String[] toSearch = "CAT TOM ADO MOM CDM".split(" ");

        // for loop to checking words presence in Grid
        for (String search : toSearch) {

            // calling  patternSearch method
            boolean isFound = patternSearch(grid, search);

            // Display Yes or No based on match
            System.out.print(isFound ? "Yes " : "No ");
        }
        System.out.println();
    }


    int m, n;
    List<String> ans = new ArrayList<String>();
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
        for (String key : sset.keySet()){
            if (sset.get(key) == 1){
                ans.add(key);
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
