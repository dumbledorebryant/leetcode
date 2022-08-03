package pass;

import java.util.Arrays;

public class lc274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int ans = 0;
        for (int i = 0; i < length; i++){
            int num = citations[i];
            if (num > i + 1)
        }
    }
}
