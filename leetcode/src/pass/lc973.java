package pass;

import java.util.PriorityQueue;
import java.util.Queue;

public class lc973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double disa = Math.pow(a[0], 2) + Math.pow(a[1], 2);
            double disb = Math.pow(b[0], 2) + Math.pow(b[1], 2);
            return (disa < disb) ? -1 : 1;
        });
        for (int[] point : points){
            queue.add(point);
        }
        for (int i = 0; i < k; i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
}
