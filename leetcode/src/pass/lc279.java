package pass;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class lc279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int item = 1;
        List<Integer> list = new ArrayList<>();
        while (item * item <= n){
            list.add(item * item);
            item++;
        }
        System.out.println(list);
        int len = list.size();
        for (int i = 0; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < len; j++){
                int it = list.get(j);
                if (i - it >= 0)
                    dp[i] = Math.min(dp[i], dp[i - it] + 1);
            } 
        }
        return dp[n];
    }
}
