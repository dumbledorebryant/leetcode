package pass;

import java.util.*;

public class lc986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int flen = firstList.length;
        int slen = secondList.length;
        int i = 0;
        int j = 0;
        List<int[] > list = new ArrayList<>();
        while (i < flen && j < slen) {
            int[] finter = firstList[i];
            int[] sinter = secondList[j];
            int a = finter[0];
            int b = finter[1];
            int c = sinter[0];
            int d = sinter[1];
            if (a <= c && b >= c && b <= d){
                list.add(new int[]{c, b});
                i++;
            }
            else if (a >= c && b >= d && a <= d){
                list.add(new int[]{a, d});
                j++;
            }
            else if (a <= c && d <= b){
                list.add(new int[]{c, d});
                j++;
            }
            else if (c <= a && b <= d){
                list.add(new int[]{a, b});
                i++;
            }
            else if (c >= b){
                i++;
            }
            else if (a >= d){
                j++;
            }
        }
        int len = list.size();
        int[][] ans = new int[len][];
        for (int m = 0; m < len; m++){
            ans[m] = list.get(m);
        }
        return ans;
    }
}
