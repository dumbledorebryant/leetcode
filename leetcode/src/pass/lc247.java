package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc247 {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        List<String> n1 = new ArrayList<>();
        n1.add("0");
        n1.add("1");
        n1.add("8");

        List<String> n2 = new ArrayList<>();
        n2.add("11");
        n2.add("69");
        n2.add("88");
        n2.add("96");
        if (n == 1) return n1;
        if (n == 2) return n2;
        n2.add("00");
        map.put(1, n1);
        map.put(2, n2);
        
        return backtrack(n, 1);
    }

    public List<String> backtrack(int n, int f){
        if (n == 1) return map.get(1);
        if (n == 2) return map.get(2);
        List<String> res = backtrack(n - 2, 0);
        List<String> ans = new ArrayList<>();
        System.out.println(n + " " + f);
        for (String str : res){
            ans.add("1" + str + "1");
            ans.add("6" + str + "9");
            ans.add("9" + str + "6");
            ans.add("8" + str + "8");
            if (f == 0) ans.add("0" + str + "0");
        }
        return ans;
    }
}
