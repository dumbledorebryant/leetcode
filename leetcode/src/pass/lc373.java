package pass;
import java.util.*;

public class lc373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] + a[1]) - (b[0] + b[1]);
        });

        int n = nums1.length;
        for (int i = 0; i < n; i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            k--;
            int next_idx = cur[2] + 1;
            if (next_idx < nums2.length){
                pq.offer(new int[]{cur[0], nums2[next_idx], next_idx});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);

            ans.add(pair);
            if (k == 0) return ans;
        }
        return ans;
    }
}
