package pass;
import java.util.*;

public class lc357 {
    int ans = 10;
    int n;
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        this.n = n;
        for (int i = 1; i <= 9; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            backtrace(set, 1);
        }
        return ans;
    }
    public void backtrace(Set<Integer> set, int idx){
        if (idx == n) {
            return;
        }
        for (int i = 0; i <= 9; i++){
            if (set.contains(i)) continue;
            else {
                ans++;
                set.add(i);
                backtrace(set, idx + 1);
                set.remove(i);
            }
        }
    }
}
