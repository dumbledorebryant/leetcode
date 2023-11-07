package pass;

import java.util.ArrayList;
import java.util.List;

public class lc544 {
    String ans = "";
    public String findContestMatch(int n) {
        List<String> ori = new ArrayList<>();
        for (int i = 1; i <= n/2; i++){
            ori.add("(" + i + "," +  (n + 1 - i) + ")");
        }
        
        helper(ori);
        return ans;
    }

    public void helper(List<String> list){
        int n = list.size();
        if (n == 1) {
            ans = list.get(0);
            return;
        }
        List<String> next = new ArrayList<>();
        for (int i = 0; i < n/2; i++){
            next.add("(" + list.get(i) + "," +  list.get(n - 1 - i) + ")");
        }
        helper(next);
    }
}
