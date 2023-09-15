package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class lc508 {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        subsum(root);
        System.out.println(map);
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        for (int k : map.keySet()){
            pq.add(k);
        }
        int max = map.get(pq.peek());
        while (!pq.isEmpty()){
            int k = pq.poll();
            if (map.get(k) != max) break;
            else res.add(k);
        }
        int n = res.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int subsum(TreeNode root){
        if (root == null) return 0;
        int l = subsum(root.left);
        int r = subsum(root.right);
        int num = root.val;
        int res = l + r + num;
        map.put(res, map.getOrDefault(res, 0) + 1);
        return res;
    }
}
