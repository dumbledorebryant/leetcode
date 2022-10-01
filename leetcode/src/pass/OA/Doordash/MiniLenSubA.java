package pass.OA.Doordash;
import java.util.*;
public class MiniLenSubA {
    /*
     * Complete the 'findMinimumLengthSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static int findMinimumLengthSubarray(List<Integer> arr, int k) {
        // Write your code here
        
        System.out.println(arr);
        System.out.println(arr.size());
        System.out.println(k);
        int ans = 0;
            
        Map<Integer,Integer> map = new HashMap<>();
            
        int l = 0;
        int r = 0;
            
        while( r < arr.size()){
                
            map.put( arr.get(r) , map.getOrDefault(arr.get(r), 0)+1);
            r++;
                
            if( map.size() < k){
                continue;
            }
                
            while( map.size() == k){
                    
                int curlen = l - r + 1;
                    
                if(curlen == k){
                    return k;
                }
                ans = Math.min(ans, curlen);
                    
                if (map.get(arr.get(l)) == 1){
                    map.remove(arr.get(l));
                }
                else {
                    map.put(arr.get(l), map.get(arr.get(l) - 1));
                }
                
                ++l;
            }
        }
        System.out.println(ans);
        return ans;      
    }
}
