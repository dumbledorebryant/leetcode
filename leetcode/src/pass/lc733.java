package pass;

public class lc733 {
    boolean[][] visited;
    int m;
    int n;
    int pre;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        pre = image[sr][sc];
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color){
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        if (image[i][j] != pre) return;
        image[i][j] = color;
        visited[i][j] = true;
        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(image, x, y, color);
        }
        visited[i][j] = false;
    }
}
