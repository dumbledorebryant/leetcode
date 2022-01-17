package pass;

import java.util.*;

public class lc179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        String[] strvals = new String[n];
        for (int i = 0; i < n; i++){
            int num = nums[i];
            strvals[i] = String.valueOf(num);
            if (num == 0){
                count++;
            }
        }
        if (count == n) return "0";
        Arrays.sort(strvals, (a, b)-> (b+a).compareTo(a+b));

        String ans = "";
        for (int i = 0; i < n; i++){
            ans += strvals[i];
        }
        return ans;
    }
    
}
