package pass;

import java.util.HashSet;
import java.util.Set;

public class lc1593 {
    Set<String> set = new HashSet<>();
    int ans = 0;
    public int maxUniqueSplit(String s) {
        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int idx){
        int n = s.length();
        if (idx == n) {
            ans = Math.max(ans, set.size());
            return;
        }

        for (int i = idx; i < n; i++){
            String sub = s.substring(idx, i + 1);
            if (set.contains(sub)) continue;
            set.add(sub);
            backtrack(s, i + 1);
            set.remove(sub);
        }
    }
}
