package pass;

import java.util.Arrays;

public class lc274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int ans = 0;
        for (int i = length - 1; i >= 0; i--){
            if (citations[i] > ans){
                ans++;
            }
        }
        return ans;
    }
}
