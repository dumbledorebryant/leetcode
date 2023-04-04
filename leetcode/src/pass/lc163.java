package pass;
import java.util.*;

import javax.swing.border.SoftBevelBorder;
public class lc163 {
    String to = "->";
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            StringBuilder sb = new StringBuilder();
            if (lower == upper)
                sb.append(lower);
            else 
                sb.append(lower).append(to).append(upper);
            ans.add(sb.toString());
            return ans;
        }
        int ptr = 0;
        int left = lower;
        int right = nums[ptr];
        while (ptr < length && nums[ptr] < upper){
            right = nums[ptr];
            if (left < right){
                StringBuilder sb = new StringBuilder();
                if (right - left == 1) 
                    sb.append(left);
                else 
                    sb.append(left).append(to).append(right - 1);
                ans.add(sb.toString());
            }
            left = right + 1;
            ptr++;
        }
        left = right + 1;
        right = upper + 1;
        if (left < right){
            StringBuilder sb = new StringBuilder();
            if (right - left == 1) 
                sb.append(left);
            else 
                sb.append(left).append(to).append(right - 1);
            ans.add(sb.toString());
        }
        return ans;
    }
}
