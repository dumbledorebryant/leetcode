package pass;
import java.util.*;
public class lc480undone {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> l = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> r = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        int n = nums.length;
        for (int i = 0; i < k; i++){
            r.add(nums[i]);
        }

        for (int i = 0; i < k/2; i++){
            l.add(r.poll());
        }
        double[] ans = new double[n - k + 1];
        ans[0] = getMid(l, r);
        for (int i = k; i < n; i++){
            int num = nums[i];
            int pre = nums[i - k];

            if (num >= r.peek()){
                r.add(num);
            }

            else {
                l.add(num);
            }

            if (pre >= r.peek()) r.remove(pre);
            else l.remove(pre);

            adjust(l, r);
            ans[i - k + 1] = getMid(l, r);
        }
        return ans;
    }

    public void adjust (PriorityQueue<Integer> l, PriorityQueue<Integer> r){
        while (r.size() < l.size()) r.add(l.poll());
        while (r.size() - l.size() > 1) l.add(r.poll());
    }

    public double getMid(PriorityQueue<Integer> l, PriorityQueue<Integer> r){
        if (r.size() == l.size() + 1){
            return r.peek() * 1.0;
        }
        else {
            return l.peek()/2.0 + r.peek()/2.0;
        }
    }
}
