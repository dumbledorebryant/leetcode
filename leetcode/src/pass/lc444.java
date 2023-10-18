package pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indegree = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> list : sequences){
            int length = list.size();
            for (int i = 0; i < length - 1; i++){
                graph[list.get(i)].add(list.get(i + 1));
                indegree[list.get(i + 1)]++;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0) dq.addLast(i);
        }
        if (dq.size() != 1) return false;
        while (!dq.isEmpty()){
            if (dq.size() != 1) return false;
            int num = dq.removeLast();
            List<Integer> nexts = graph[num];
            for (int next : nexts){
                indegree[next]--;
                if (indegree[next] == 0) dq.addLast(next);
            }
            
        }

        return true;
    }
}
