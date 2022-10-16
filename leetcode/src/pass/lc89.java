package pass;
import java.util.*;
public class lc89 {
    Set<Integer> set = new HashSet<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        set.add(0);
        ans.add(0);
        backtrace(n, 0);
        return ans;
    }
    public void backtrace(int n, int num){
        for (int i = 0; i < n; i++){
            int nnum = (num ^ (1 << i));
            if (set.contains(nnum)) continue;
            set.add(nnum);
            ans.add(nnum);
            backtrace(n, nnum);
        }
    }
}
