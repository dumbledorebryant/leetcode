package pass;
import java.util.*;

public class lc1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            int num = prices[i];
            while (!dq.isEmpty() && prices[dq.getLast()] >= num){
                prices[dq.removeLast()] -= num;
            }
            dq.addLast(i);
        }
        return prices;
    }
}
