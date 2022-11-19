package pass;

import java.util.*;

public class lc587 {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) return trees;
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<Integer> points = new ArrayList<>();
        points.add(0);
        boolean[] visited = new boolean[n];

        for (int i = 1; i < n; i++){
            int[] r = trees[i];
            while (points.size() > 1){
                int size = points.size();
                int[] p = trees[points.get(size - 2)];
                int[] q = trees[points.get(size - 1)];
                if (cross(p, q, r) < 0){
                    int idx = points.remove(size - 1);
                    visited[idx] = false;
                }
                else break;
            }
            points.add(i);
            visited[i] = true;
        }
        for (int i = n - 2; i >= 0; i--){
            if (visited[i]) continue;
            int[] r = trees[i];
            while (points.size() > 1){
                int size = points.size();
                int[] p = trees[points.get(size - 2)];
                int[] q = trees[points.get(size - 1)];
                if (cross(p, q, r) < 0){
                    int idx = points.remove(size - 1);
                    visited[idx] = false;
                }
                else break;
            }
            points.add(i);
            visited[i] = true;
        }

        points.remove(points.size() - 1);
        int m = points.size();
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++){
            ans[i] = trees[points.get(i)];
        }
        return ans;
    }

    private int cross(int[] p, int[] q, int[] r){
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}
