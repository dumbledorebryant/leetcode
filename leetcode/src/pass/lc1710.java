package pass;
import java.util.*;

public class lc1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        int i = 0;
        int length = boxTypes.length;
        while (truckSize > 0 && i < length){
            int num = boxTypes[i][0];
            int unit = boxTypes[i][1];
            if (truckSize > num){
                truckSize -= num;
                ans += (num * unit);
            }
            else {
                
                ans += (truckSize * unit);
                truckSize = 0;
            }
            i++;
        }
        return ans;
    }
}
