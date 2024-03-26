package pass;

import java.util.ArrayList;
import java.util.List;

public class lc260 {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 32; i++){
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < n; j++){
                int num = nums[j];
                if (((num >> i) & 1) == 1){
                    a.add(num);
                }
                else b.add(num);
            }
            if (a.size() % 2 != 0){
                int m = 0;
                for (int num : a){
                    m ^= num;
                }
                int k = 0;
                for (int num : b){
                    k ^= num;
                }
                return new int[]{m, k};
            }
        }
        return new int[]{-1, -1};
    }
}
