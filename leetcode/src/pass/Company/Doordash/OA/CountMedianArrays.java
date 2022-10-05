package pass.Company.Doordash.OA;

import java.util.HashMap;

import java.util.*;

public class CountMedianArrays {
    public int getMedianSubarrays(int[] eff, int k){
        k -= 1;
        int ele = eff[k];
        int length = eff.length;
        int[] diff = new int[length];
        for (int i = 0; i < length; i++){
            int num = eff[i];
            if (num < ele) diff[i] = 1;
            else if (num == ele) diff[i] = 0;
            else diff[i] = -1;
        }

        return countSumZero(diff, 0, length) 
            - countSumZero(diff, 0, k)
            - countSumZero(diff, k + 1, length);
    }

    public int countSumZero(int[] nums, int start, int end){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = start; i < end; i++){
            sum += nums[i];
            if (sum == 0){
                ans++;
            }
            if (map.containsKey(sum)){
                ans += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] eff = {5, 3, 1, 4, 7, 7};
        int k = 4;
        CountMedianArrays cma = new CountMedianArrays();
        System.out.println(cma.getMedianSubarrays(eff, k));
    }
}
