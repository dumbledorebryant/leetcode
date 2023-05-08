package pass;
import java.util.*;
public class lc658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        int idx = findPos(arr, x);
        int left = idx; 
        int right = idx + 1;
        List<Integer> ans = new ArrayList<>();
        while (left >= 0 && right < length && k > 0){
            int lnum = arr[left];
            int rnum = arr[right];
            if (Math.abs(x - lnum) <= Math.abs(rnum - x)) {
                ans.add(lnum);
                left--;
            } 
            else {
                ans.add(rnum);
                right++;
            }
            k--;
        }
        if (left < 0) {
            for (int i = 0; i < k; i++){
                ans.add(arr[right]);
                right++;
            }
        }
        else if (right >= length){
            for (int i = 0; i < k; i++){
                ans.add(arr[left]);
                left--;
            }
        }
        Collections.sort(ans);
        return ans;
    }
    private int findPos(int[] arr, int x){
        if (x < arr[0]) return -1;
        int length = arr.length;
        int idx = 0;
        while (idx < length){
            if (x < arr[idx]) break;
            if (x >= arr[idx]) idx++;
        }
        return idx - 1;
    }
}
