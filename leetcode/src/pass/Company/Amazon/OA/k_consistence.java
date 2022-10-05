package pass.Company.Amazon.OA;

import java.util.HashMap;
import java.util.Map;

public class k_consistence {
    public int characterDelete(int[] array, int k) {
        if (array == null || array.length == 0 || k > array.length) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxCount = 0;
        // sliding window
        for (int end = 0; end < array.length; end++) {
            int count = map.getOrDefault(array[end], 0) + 1;
            maxCount = Math.max(maxCount, count);
            map.put(array[end], count);
            // in the sliding window, max consecutive integer
            while (end - start + 1 - maxCount > k) {
                int value = map.get(array[start]);
                map.put(array[start], value - 1);
                start++;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) throws Exception 
    {
        int[] stocks1 = new int[] {1, -2, 1, 1, 3, 2, 1, -2}; //14
        int[] stocks2 = new int[] {7, 5,7,7,1,1,7,7}; //14
        int[] stocks3 = new int[] {1,1,2,1,2,1,3,4};
        k_consistence kc = new k_consistence();
        System.out.println(kc.characterDelete(stocks3, 3));
    }
}
