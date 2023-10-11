package pass;

import java.util.HashSet;
import java.util.Set;

public class lc997 {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int[] t : trust){
            int a = t[0];
            int b = t[1];
            count[a - 1]++;
        }
        int judge = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (count[i] == 0){
                judge = i + 1;
                cnt++;
            }
        }
        if (cnt != 1) return -1;
        Set<Integer> ppl = new HashSet<>();
        for (int[] t : trust){
            if (t[1] == judge){
                set.add(t[0]);
            }
        }
        return set.size() == n - 1 ? judge : -1;
    }
}
