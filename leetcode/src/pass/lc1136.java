package pass;

import java.util.*;

public class lc1136 {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] relation : relations){
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            indegree[next]++;
            graph[prev].add(next);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indegree[i] == 0)
                queue.addLast(i);
        }

        int ans = 0;
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++){
                int c = queue.removeFirst();
                count++;
                for (int next : graph[c]){
                    indegree[next]--;
                    if (indegree[next] == 0)
                        queue.addLast(next);
                }
            }
        }
        if (count != n) return -1;
        return ans;
    }
}
