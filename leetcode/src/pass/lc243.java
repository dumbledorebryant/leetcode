package pass;
import java.util.*;
public class lc243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int a = -n;
        int b = 2 * n;
        int ptr = 0;
        int ans = n;
        while (ptr < n){
            if (wordsDict[ptr].equals(word1))
                a = ptr;
            if (wordsDict[ptr].equals(word2))
                b = ptr;
            int num = Math.abs(b - a);
            if (num > 0){
                ans = Math.min(ans, num);
            }
                
            ptr++;
        }
        return ans;
    }
}
