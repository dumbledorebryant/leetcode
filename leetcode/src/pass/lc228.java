package pass;
import java.util.*;
public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> ans = new ArrayList<>();
        if (length == 0) return ans;
        int idx = -1;
        for (int i = 0; i < length; i++){
            StringBuilder sb = new StringBuilder();
            idx = nums[i];
            sb.append(idx);
            i++;
            boolean flag = false;
            while (i < length && nums[i] == idx + 1){
                i++;
                idx++;
                flag = true;
            }
            i--;
            if (flag) sb.append("->").append(idx);
            ans.add(sb.toString());
        }
        return ans;
    }
}
