package pass;

import java.util.ArrayList;
import java.util.List;

public class lc264 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] array = new int[n + 1];
        array[1] = 1;
        int ptr = 2;
        int a = 1;
        int b = 1;
        int c = 1;
        while (ptr <= n){
            int numa = array[a] * 2;
            int numb = array[b] * 3;
            int numc = array[c] * 5;
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
            array[ptr] = min;
            ptr++;
        }
        return array[n];
    }
}
