package pass.OA.Palantir.Karat;

import java.util.*;


public class FindTreasures {
    int n;
    int m;
    int[] trg;
    int[][] direction = {{1,0}, {0,1}, {0,-1}, {-1,0}};
    int tot_diamonds = 0;
    List<int[]> res = new ArrayList<>();
    
    public void findAllTreasures(int[][] board, int[] start, int[] end) {
        trg = end;
        n = board.length;
        m = board[0].length;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 1){
                    tot_diamonds++;
                }
            }
        }
        
        dfs(board, start[0], start[1], new boolean[n][m], 0, new ArrayList<int[]>());
        for (int[] i : res){
            System.out.print(Arrays.toString(i));
        }
    }
    
    public void dfs(int[][] board, int x, int y, 
                           boolean[][] visited, int cur_diamonds, List<int[]> path)
    {
        if (x >= n || x < 0 || y >= m || y < 0 || visited[x][y] || board[x][y] == -1){
            return;
        }
        
        path.add(new int[]{x,y});
        visited[x][y] = true;

        if (board[x][y] == 1){
            cur_diamonds++;
        }
        
        if (x == trg[0] && y == trg[1]){
            if (cur_diamonds == tot_diamonds && (res.size() == 0 || path.size() < res.size())){
                res = new ArrayList<>(path);
            }
            visited[x][y] = false;
            path.remove(path.size() - 1);
            return;
        }
        
        for (int[] d : direction){
            dfs(board, x + d[0], y + d[1], visited, cur_diamonds, path);
        }
        path.remove(path.size() - 1);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        FindTreasures kt = new FindTreasures();
        int[][] board = new int[][]{
            { 1,  0,  0,  0,  0},
            { 0, -1, -1,  0,  0},
            { 0, -1,  0,  1,  0},
            {-1,  0,  0,  0,  0},
            { 0,  1, -1,  0,  0},
            { 0,  0,  0,  0,  0}
        };
        int[] start = new int[]{5, 2};
        int[] end = new int[]{2, 0};
        kt.findAllTreasures(board, start, end);
    }
}
