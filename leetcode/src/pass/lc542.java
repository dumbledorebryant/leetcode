package pass;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lc542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 记录答案的结果数组
        int[][] res = new int[m][n];
        // 初始化全部填充特殊值 -1，代表未计算，
        // 待会可以用来判断坐标是否已经计算过，避免重复遍历
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        // 初始化队列，把那些值为 0 的坐标放到队列里
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }
        // 执行 BFS 算法框架，从值为 0 的坐标开始向四周扩散
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            // 向四周扩散
            for (int i = 0; i < 4; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];
                // 确保相邻的这个坐标没有越界且之前未被计算过
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && res[nextX][nextY] == -1) {
                    q.offer(new int[]{nextX, nextY});
                    // 从 mat[x][y] 走到 mat[nextX][nextY] 需要一步
                    res[nextX][nextY] = res[x][y] + 1;
                }
            }
        }
        return res;
    }
}
