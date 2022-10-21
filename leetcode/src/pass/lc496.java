package pass;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Arrays.sort(nums1, (a, b)->{
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        Deque<Integer> stack = new LinkedList<>();
        int len = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int idx = stack.pop();
                map.put(nums2[idx], nums2[i]);
            }
            stack.push(i);
        }
        int length = nums1.length;
        int[] ans = new int[length];
        Arrays.fill(nums1, -1);
        for (int i = 0; i < length; i++){
            if (map.containsKey(nums1[i]))
                ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    public int[] next(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int len = nums2.length;
        int[] ans = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = len - 1; i >= 0; i--){
            while (!s.empty() && s.peek() <= nums2[i]){
                s.pop();
            }

            map.put(nums2[i], s.empty() ? -1 : s.peek());
            s.push(nums2[i]);
        }
        for (int i = 0; i < length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    
}
