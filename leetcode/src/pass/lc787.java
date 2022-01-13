package pass;

import java.util.*;

public class lc787 {
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        this.src = src;
        this.dst = dst;
        memo = new int[n][k + 1];
        for (int[] row : memo){
            Arrays.fill(row, -888);
        }
        indegree = new HashMap<>();

        for (int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }
    public int dp(int s, int k){
        if (s == src) return 0;
        if (k == 0) return -1;
        if (memo[s][k] != -888){
            return memo[s][k];
        }
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)){
            for (int[] v : indegree.get(s)){
                
                int from = v[0];
                int price = v[1];

                int subp = dp(from, k - 1);
                if (subp != -1){
                    res = Math.min(res, subp + price);
                }
            }
        }
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}
