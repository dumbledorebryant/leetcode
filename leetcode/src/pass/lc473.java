package pass;

import java.util.Arrays;

public class lc473 {
    int len;
    boolean[] used;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        int i = 0; int j = n - 1;
        while (i < j){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;
            j--;
        }
        for (int num : matchsticks){
            sum += num;
        }
        if (sum % 4 != 0) return false;
        len = sum / 4;
        
        used = new boolean[n];
        int[] bucket = new int[4];
        return backtrack(matchsticks, bucket, 0, 0);
    }

    public boolean backtrack(int[] sticks, int[] bucket, int idx, int start){
        int n = sticks.length;
        if (idx == 4){
            return true;
        }
        if (bucket[idx] == len) {
            return backtrack(sticks, bucket, idx + 1, 0);
        }
        for (int i = start; i < n; i++){
            if (used[i]) continue;
            int num = sticks[i];
            
            if (bucket[idx] + num > len) continue;
            used[i] = true;
            bucket[idx] += num;
            
            if (backtrack(sticks, bucket, idx, i + 1)) return true;
            
            used[i] = false;
            bucket[idx] -= num;
        }
        return false;
    }
}
