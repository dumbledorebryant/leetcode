package pass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1387 {
    Map<Integer, Integer> map = new HashMap<>();
    class Pair{
        int i;
        int j;
        public Pair(int a, int b){
            i = a;
            j = b;
        }
    }
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        Pair[] arr = new Pair[n];
        
        for (int i = lo; i <= hi; i++){
            int num = calcu(i);
            arr[i - lo] = new Pair(i, num);
            System.out.println("i: " + i + " num: " + num);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.j == b.j) return a.i - b.i;
            else return a.j - b.j;
        });

        return arr[k - 1].i;
    }

    public int calcu(int i){
        if (map.containsKey(i)) return map.get(i);
        if (i == 1) return 0;
        if (i == 2) return 1;

        int ans = -1;
        if (i % 2 == 0) ans = calcu(i / 2) + 1;
        else {
            ans = calcu(i * 3 + 1) + 1;
        } 
        map.put(i, ans);
        return ans;
    }
}
