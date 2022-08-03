package pass;

import java.util.ArrayList;
import java.util.List;

public class lc264 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l5 = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            l2.add(2 * i);
            l3.add(3 * i);
            l5.add(5 * i);
        }
        int ptr = 2;
        int cur = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        while (ptr <= n){
            int numa = l2.get(a);
            int numb = l3.get(b);
            int numc = l5.get(c);
            int min = Math.min(Math.min(numa, numb), numc);
            if (min == numa){
                a++;
            }
            if (min == numb){
                b++;
            }
            if (min == numc){
                c++;
            }
            cur = min;
            ptr++;
        }
        return cur;
    }
}
