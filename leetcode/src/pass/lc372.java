package pass;

import java.util.*;

public class lc372 {
    int mod = 1337;
    List<Integer> list;
    public int superPow(int a, int[] b) {
        list = new ArrayList<>();
        for (int num : b) list.add(num);
        return supp(a);
    }
    public int supp(int a){
        if (list.isEmpty()) return 1;
        int len = list.size();
        int last = list.get(len - 1);
        list.remove(len - 1);
        int prev = mypower(a, last);
        int next = mypower(supp(a), 10);
        return ((prev % mod) * (next % mod)) % mod;
    }

    public int mypower(int a, int k){
        if (k == 0) return 1;
        a %= mod;
        if (k % 2 == 0){
            int half = mypower(a, k/2);
            return ((half % mod) * (half % mod)) % mod;
        }
        else {
            return (a * mypower(a, k - 1)) % mod;
        }
        //int ans = b;
        //for (int i = 1; i < k; i++){
        //    ans *= b;
        //    ans %= mod;
        //}
        //return ans;
    }
}
