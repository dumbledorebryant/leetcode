package pass;
import java.util.*;
public class lc480 {
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

    public double[] medianSlidingWindow222(int[] nums, int k) {
        
        List<Integer> windows = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            windows.add(nums[i]);
        }

        double[] result = new double[nums.length - k + 1];
        Collections.sort(windows);
        result[0] = getmid(windows, k);

        for (int i = 0 ; i < nums.length - k; i++) {
            windows.remove((Object)nums[i]);
            int j = 0;
            int tmp = nums[i + k];
            binarySearchAdd(windows, tmp);
            result[i + 1] = getmid(windows, k);
        }

        return result;
    }

    public static double getmid(List<Integer> wondows, int k) {
    if (k % 2 == 1) {
        double d = wondows.get(k / 2);
        return d;
    } else {
        double d = wondows.get( k / 2);
        double d1 = wondows.get(k / 2 - 1);
        return (d + d1) / 2;
    }
    }

    public static void binarySearchAdd(List<Integer> windows, int tmp) {
    int left = 0;
    int right = windows.size() - 1;
    int flag = 0;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int num = windows.get(mid);
        if (num < tmp) {
            left = mid + 1;
            flag = 1;
        } else if (num > tmp) {
            right = mid - 1;
            flag = 2;
        } else if (num == tmp) {
            windows.add(mid, tmp);
            flag = 3;
            break;
        }
    }

    if (flag == 1) {
        if (left < windows.size()) {
            windows.add(left, tmp);
        } else {
            windows.add(tmp);
        }
    } else if (flag == 2) {
        if (right < 0) {
            windows.add(0, tmp);
        } else {
            windows.add(left, tmp);
        }
    } else if (flag == 0) {
        windows.add(tmp);
    }
    }
}
