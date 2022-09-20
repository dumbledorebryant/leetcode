package pass;

import java.util.*;

public class lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains){
            String[] list = str.split(" ");
            int num = Integer.valueOf(list[0]);
            String domain = list[1];
            String[] dlist = domain.split("\\.");
            int length = dlist.length;
            for (int i = 0; i < length; i++){
                if (domain.charAt(i) == '.'){
                    String s = domain.substring(i + 1);
                    map.put(s, map.getOrDefault(s, 0) + num);
                }
            }
        }
        for (String key : map.keySet()){
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}
