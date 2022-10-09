package pass;

import java.lang.reflect.WildcardType;

public class lc1011 {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int weight : weights){
            l = Math.max(l, weight);
            r += weight;
        }

        while (l <= r){
            int mid = l + (r - l)/2;
            int num = checkDays(weights, mid);
            if (num > days){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
    public int checkDays(int[] weights, int k){
        int ans = 0;
        int n = weights.length;
        for (int i = 0; i < n;){
            int cap = k;
            while (i < n){
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int k = 10;
        lc1011 lc = new lc1011();
        System.out.println(lc.checkDays(weights, k));
    }
}
