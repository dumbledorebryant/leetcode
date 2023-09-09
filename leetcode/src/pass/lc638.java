package pass;

import java.util.ArrayList;
import java.util.List;

public class lc638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return bt(0, price, special, needs);
    }

    public int bt(int pos, List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int sum = 0;
        int len = needs.size();
        for (int i = 0; i < len; i++){
            sum += needs.get(i) * price.get(i);
        }
        
        int n = special.size();
        for (int i = pos; i < n; i++){
            List<Integer> offer = special.get(i);
            List<Integer> left = new ArrayList<>(needs);
            int m = needs.size();
            boolean flag = true;
            for (int j = 0; j < m; j++){
                int num = left.get(j) - offer.get(j);
                if (num < 0) {
                    flag = false;
                    break;
                }
                left.set(j, num);
            }
            if (!flag) continue;
            
            sum = Math.min(sum, offer.get(m) + bt(i, price, special, left));
        }
        return sum;
    }
}
