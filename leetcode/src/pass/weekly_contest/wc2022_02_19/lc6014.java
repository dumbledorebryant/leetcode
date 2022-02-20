package pass.weekly_contest.wc2022_02_19;

import java.util.*;

public class lc6014 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] rd = new int[26];
        int cnt=0, cur=0;
        for(char c : s.toCharArray()){
            rd[c-'a']++;
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        while(cnt > 0){
            int t = 25;
            while(t >= 0 && rd[t] == 0){
                t--;
            }
            if (t >= 0){
                if (sb.length() > 0 && sb.charAt(sb.length()-1)==t+'a'){
                    if(cur==repeatLimit){
                        t--;
                        while(t>=0 && rd[t]==0){
                            t--;
                        }
                        if(t<0)break;
                        sb.append((char)(t+'a'));
                        cur=1;
                        rd[t]--;
                    }else{
                        sb.append((char)(t+'a'));
                        cur++;
                        rd[t]--;
                    }
                }else{
                    sb.append((char)(t+'a'));
                    cur=1;
                    rd[t]--;
                }
            }else break;
        }
        return sb.toString();
    }
}
