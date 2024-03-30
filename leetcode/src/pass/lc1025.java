package pass;

import java.util.Arrays;

public class lc1025 {
    int[] res;
    public boolean divisorGame(int n) {
       res = new int[n + 1];
       

       Arrays.fill(res, -1);
       res[0] = 0;
       res[1] = 0;
       check(n);
       return res[n] == 1;
    }

    public int check(int n){
        if (res[n] != -1) return res[n];
        for (int i = 1; i < n; i++){
            if (n % i == 0){
                if (check(n - i) == 0) {
                    res[n] = 1;
                    return 1;
                }
            }
            else continue;
        }
        res[n] = 0;
        return 0;
    }
}
