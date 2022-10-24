package pass;
import java.util.*;;
public class lc1102 {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
		pq.offer(new int[]{grid[0][0], 0, 0});

		int maxScore = grid[0][0];

        //marking as visited
		grid[0][0] = -1; 

		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
            maxScore = Math.min(maxScore, curr[0]);
            if (curr[1] == m - 1 && curr[2] == n - 1)
                break;
			for (int[] d : dir){
				int r = curr[1] + d[0];
				int c = curr[2] + d[1];
				if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] >= 0) {
					pq.offer(new int[]{grid[r][c], r, c});
					grid[r][c] = -1;
				}
			}
		}
		return maxScore;
    }
}
