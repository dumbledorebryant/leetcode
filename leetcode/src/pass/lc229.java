package pass;

import java.util.ArrayList;
import java.util.List;

public class lc229 {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        int n = nums.length;
        for (int num : nums){
            if (c != 0 && a == num){
                c++;
            }
            else if (d != 0 && b == num){
                d++;
            }

            else if (c == 0){
                c = 1;
                a = num;
            }

            else if (d == 0){
                d = 1;
                b = num;
            }

            else {
                c--;
                d--;
            }
        }

        c = 0;
        d = 0;
        for (int num : nums){
            if (num == a) c++;
            else if (num == b) d++;
        }
        List<Integer> ans = new ArrayList<>();
        if (c > n/3) ans.add(a);
        if (d > n/3) ans.add(b);
        return ans;
    }
}
