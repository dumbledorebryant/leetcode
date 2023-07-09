package pass;

import java.util.*;

public class lc386 {
    int length;
    List<Integer> ans = new ArrayList<>();
    int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        String num = String.valueOf(n);
        length = num.length();
        dfs(0, 0);
        return ans;
    }

    public void dfs(int idx, int pre){
        if (idx == length - 1){
            for (int i = 0; i <= 9; i++){
                int v = pre * 10 + i;
                if (v <= n && v != 0) ans.add(v);
            }
            return;
        }
        else {
            for (int i = 0; i <= 9; i++){
                int v = pre * 10 + i;
                if (v != 0){
                    ans.add(v);
                    dfs(idx + 1, v);
                }
            }
        }
    }
}
