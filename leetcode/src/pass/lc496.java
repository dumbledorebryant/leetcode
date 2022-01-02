package pass;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
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
