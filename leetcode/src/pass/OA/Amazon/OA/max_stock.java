package pass.OA.Amazon.OA;

import java.util.HashMap;
import java.util.Map;

public class max_stock {
    int getMaxStock(int[] stocks, int k){
        int length = stocks.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        int[] prefix = new int[length + 1];
        for (int i = 1; i <= length; i++){
            prefix[i] = prefix[i - 1] + stocks[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (right < length) {
            int num = stocks[right];
            sum += num;
            if (map.containsKey(num)){
                int next = map.get(num) + 1;
                sum -= (prefix[next] - prefix[left]);
                left = next;
                map.put(num, right);
            }
            else {
                map.put(num, right);
                if (right - left + 1 == k){
                    ans = Math.max(ans, sum);
                    sum -= stocks[left];
                    left++;
                }
            }   
            right++;
        }
        if (ans == 0) return -1;
        return ans;
    }

    public static void main(String[] args) throws Exception 
    {
        int[] stocks = new int[] {1, 2, 7, 7, 4, 3, 6}; //14
        max_stock ms = new max_stock();
        System.out.println(ms.getMaxStock(stocks, 3));
    }
}
