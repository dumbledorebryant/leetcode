package pass;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class lc1761 {
    int ans = Integer.MAX_VALUE;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int minTDegree(int n, int[][] edges) {
        
        for (int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            map.computeIfAbsent(nodeA, k -> new HashSet<>()).add(nodeB);
            map.computeIfAbsent(nodeB, k -> new HashSet<>()).add(nodeA);
        }

        for (int key : map.keySet()){
            findTrio(key, key, 0, 0);
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans - 3;
    }   

    public void findTrio(int start, int node, int k, int sum){
        Set<Integer> set = map.get(node);
        sum += set.size();
        if (k == 2 && set.contains(start)){
            ans = Math.min(ans, sum);
            return;
        }
        if (k == 2) return;

        for (int next : set){
            findTrio(start, next, k + 1, sum);
        }
    }

    public int minTrioDegrees(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        int[] degree = new int[n];
        for (int[] edge : edges){
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            matrix[a][b] = 1;
            matrix[b][a] = 1;
            degree[a]++;
            degree[b]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (matrix[i][j] != 1) continue;
                for (int k = j + 1; k < n; k++){
                    if (matrix[i][k] != 1 || matrix[j][k] != 1) continue;
                    int d = degree[i] + degree[j] + degree[k] - 6;
                    ans = Math.min(ans, d);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
