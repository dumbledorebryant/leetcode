package pass;

import java.util.PriorityQueue;

public class lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int ans = 0;
        for (int[] cost : costs){
            ans += cost[1];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] cost : costs){
            pq.add(cost[0] - cost[1]);
        }

        for (int i = 0; i < length/2; i++){
            ans += pq.poll();
        }
        return ans;
    }
}
