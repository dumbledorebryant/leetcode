package pass;

import java.util.HashSet;
import java.util.Set;

public class lc202 {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (true){
            String str = String.valueOf(n);
            int sz = str.length();
            int count = 0;
            for (int i = 0; i < sz; i++){
                count += Math.pow(Integer.valueOf(str.substring(i, i + 1)), 2);
            }
            if (visited.contains(count)) {
                if (count == 1) return true;
                else return false;
            }
            else visited.add(count);
            n = count;
        }
    }
}
