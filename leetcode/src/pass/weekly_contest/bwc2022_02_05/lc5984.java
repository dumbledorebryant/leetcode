package pass.weekly_contest.bwc2022_02_05;

import java.util.Arrays;

public class lc5984 {
    public int minimumSum(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        Arrays.sort(chrs);
        String left = "";
        left += chrs[0];
        left += chrs[2];
        int l = Integer.valueOf(left);
        String right = "";
        right += chrs[1];
        right += chrs[3];
        int r = Integer.valueOf(right);
        
        return l + r;
    }
}
