package pass;
import java.util.*;
public class lc324 {
    public void wiggleSort(int[] nums) {
        int length = nums.length;
        int[] help = nums.clone();
        Arrays.sort(help);
        int N = length;
        for (int i = 1; i < length; i += 2){
            N--;
            nums[i] = help[N];
        }
        for (int i = 0; i < length; i += 2){
            N--;
            nums[i] = help[N];
        }
    }
}
