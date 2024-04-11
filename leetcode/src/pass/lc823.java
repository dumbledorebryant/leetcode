package pass;
import java.util.*;

public class lc823 {
    final static int mod = (int)(1e9 + 7);
    Map<Integer, Integer> map = new HashMap<>();
    long[] list;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        list = new long[n];
       
        long ans = 0;
        for (int i = 0; i < n; i++){
            ans += dp(arr, i);
        }
        return (int)(ans % mod);
    }

    public long dp(int[] arr, int idx){
        
        if (list[idx] != 0) return list[idx];
        int num = arr[idx];
        long res = 1;
        
        for (int i = 0; i < idx; i++){
            int cur = arr[i];
            int left = num % cur;
            int pair = num / cur;
            if (left == 0 && map.containsKey(pair)){
                res += ((dp(arr, i) * dp(arr, map.get(pair))) % mod);
            }
        }
        res %= mod;
        list[idx] = res;
        return res;
    }
}
