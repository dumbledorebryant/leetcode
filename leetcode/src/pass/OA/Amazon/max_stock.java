package pass.OA.Amazon;

import java.util.HashMap;
import java.util.Map;

public class max_stock {
    int getMaxStock(int[] stocks, int k){
        int length = stocks.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < length) {
            int num = stocks[right];
            
            if (map.containsKey(num)){
                if (right - left + 1 == k){
                    ans = Math.max(ans, sum);
                }
                int next = map.get(num) + 1;
                for (int i = left; i < next; i++){
                    sum -= stocks[i];
                }
                map.put(num, right);
                left++;
                right++;
            }
            else {
                sum += num;
                map.put(num, right);
                if (right - left + 1 == k){
                    ans = Math.max(ans, sum);
                    sum -= stocks[left];
                    left++;
                }
                right++;
            }   
        }
        return ans;
    }
}
