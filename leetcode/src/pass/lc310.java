package pass;
import java.util.*;

public class lc310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            degree[a]++;
            degree[b]++;
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (degree[i] == 1){
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()){
            ans.clear();
            ans.addAll(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int a = queue.removeFirst();
                List<Integer> next = map.get(a);
                for (int num : next){
                    degree[num]--;
                    if (degree[num] == 1){
                        queue.addLast(num);
                    }
                }
            }
        }
        return ans;
    }
}
