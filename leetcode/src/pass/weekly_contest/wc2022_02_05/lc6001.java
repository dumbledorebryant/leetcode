package pass.weekly_contest.wc2022_02_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class lc6001 {
    public long smallestNumber(long num) {
        String str = String.valueOf(num);
        if (num > 0){
            int length = str.length();
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            int i = 0;
            while (i < length && chrs[i] == '0'){
                i++;
            }
            if (i == length) return 0;
            else {
                char temp = chrs[i];
                chrs[i] = chrs[0];
                chrs[0] = temp;
                return strTolong(chrs);
            }
        }
        else if (num == 0) return 0;
        else{
            num = -num;
            str = String.valueOf(num);
            int length = str.length();
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            char[] nchrs = new char[length];
            for (int i = 0; i < length; i++){
                nchrs[i] = chrs[length - 1 - i];
            }
            return -strTolong(nchrs);
        }
    }
    public long strTolong(char[] chrs){
        int length = chrs.length;
        long ans = 0;
        for (int i = 0; i < length; i++){
            int num = Integer.parseInt(String.valueOf(chrs[i]));
            ans += (num * Math.pow(10, length - 1 - i));
        }
        return ans;
    }
}