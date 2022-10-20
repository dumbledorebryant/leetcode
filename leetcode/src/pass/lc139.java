package pass;
import java.util.*;
public class lc139 {
    Set<String> set;
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        memo = new int[len];
        set = new HashSet<>(wordDict);
        return check(s, 0);
    }

    public boolean check(String s, int idx){
        int length = s.length();
        if (idx == length){
            return true;
        }
        if (memo[idx] == -1) return false;
        for (int i = idx; i < length; i++){
            String str = s.substring(idx, i + 1);
            if (!set.contains(str)){
                continue;
            }
            boolean flag = check(s, i + 1);
            if (flag){
                return true; 
            }
        }
        memo[idx] = -1;
        return false;
    }
}
