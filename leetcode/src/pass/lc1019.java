package pass;

public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        ListNode p = head;
        int idx = 0;
        List<int[]> list = new ArrayList<>();
        while (p != null){
            int val = p.val;
            while (!dq.isEmpty() && dq.getLast()[1] < val){
                int[] prev = dq.removeLast();
                prev[1] = val;
                list.add(prev);
            }
            dq.addLast(new int[]{idx, val});
            idx++;
            p = p.next;
        }
        while (!dq.isEmpty()){
            int[] prev = dq.removeLast();
            prev[1] = 0;
            list.add(prev);
        }

        int[] ans = new int[idx];
        for (int[] res : list){
            ans[res[0]] = res[1];
        }
        return ans;
    }
}
